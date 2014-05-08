package com.irislabs.tcga;

import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Multimap;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Author: spartango
 * Date: 2/5/14
 * Time: 7:15 PM.
 */
public class SlideIndex {
    public static final int FFPE            = 0;
    public static final int FROZEN          = 1;
    public static final int FFPE_AND_FROZEN = FFPE + FROZEN;

    public static final String TCGA_ROOT     = "https://tcga-data.nci.nih.gov/tcgafiles/ftp_auth/distro_ftpusers/anonymous/tumor/";
    public static final String CLINICAL_PATH = "/bcr/";

    private static final String SEPARATOR = "-";
    private static final int    SITE      = 0;
    private static final int    PATIENT   = 1;
    private static final String FFPE_CODE = "-DX";

    private String                   diseaseCode;
    private Multimap<String, String> slideUrls;
    private int                      slideTypes;

    public SlideIndex(String diseaseCode) {
        this(diseaseCode, FFPE_AND_FROZEN);
    }

    public SlideIndex(String diseaseCode, int types) {
        this.diseaseCode = diseaseCode;
        this.slideTypes = types;
        slideUrls = fetch();
    }


    public Multimap<String, String> getSlideUrls() {
        return slideUrls;
    }

    private Multimap<String, String> fetch() {
        return scrapePage(TCGA_ROOT + diseaseCode + CLINICAL_PATH);
    }

    private Multimap<String, String> scrapePage(String url) {
        ListMultimap<String, String> urls = LinkedListMultimap.create();
        try {
            Document doc = Jsoup.connect(url).get();
            Elements links = doc.select("a");
            for (Element link : links) {
                String text = link.text();
                String target = link.attr("href");

                // Check if this is a directory
                if (text.endsWith("/")) {
                    // Recursively scan the directory
                    urls.putAll(scrapePage(url + target));
                } else if (text.endsWith(".svs")) {
                    // Check if it is FFPE
                    boolean ffpe = text.contains(FFPE_CODE);
                    if (slideTypes == FFPE_AND_FROZEN
                        || (ffpe && slideTypes == FFPE)
                        || (!ffpe && slideTypes == FROZEN)) {

                        // Parse the patient+site identifier out
                        String[] patientParts = text.split("-");
                        if (patientParts.length >= 3) {
                            urls.put(patientParts[SITE + 1] + SEPARATOR + patientParts[PATIENT + 1], url + target);
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error indexing " + url + ": " + e);
        }
        return urls;
    }

    protected Collection<String> getSlides(String identifier) {
        return getSlideUrls().get(identifier);
    }

    public Collection<String> getSlides(String site, String patient) {
        return getSlides(site + SEPARATOR + patient);
    }

    public Collection<String> getSlidesForSite(String site) {
        List<String> slides = new LinkedList<String>();

        for (Map.Entry<String, String> entry : getSlideUrls().entries()) {
            String idSite = entry.getKey().split(SEPARATOR)[SITE];
            if (idSite.equals(site)) {
                slides.add(entry.getValue());
            }
        }

        return slides;
    }
}
