# TCGA Indexer


## What?

This tool searches the [The Cancer Genome Atlas](http://cancergenome.nih.gov)(TCGA) for whole slide images, and provides a listing of those slides for download and review. 

## Why?

The TCGA is a massive repository of cancer patient data aggregated by the [NCI](http://www.cancer.gov) and [NHGRI](https://www.genome.gov) centers of the [NIH](http://www.nih.gov). The data is sourced from many cancer centers and includes clinical records, genomic, proteomic, and epigenoimic information for each patient. 

While many studies have focused on analysing the genomic and clinical data in TCGA, few have analyzed the high-resolution biopsy images that go along with that data. The TCGA's data portal is relatively unfriendly with respect to programmatic downloading of these images; they are disorganized and not grouped with patient information. 

## How?

This simple tool searches the open-access HTTP directory to find slides wherever they are stored. It groups the slides with their patient identifier and site identifier.

### Prerequisites

You'll need [Java 6](http://www.java.com/en/) or above installed to use this tool in any form. It should work on any operating system that supports Java (Windows, Mac OS X, Linux, Solaris).

There are two ways to use it:

### Use as an Application

The easiest way to get started with the Indexer is to download the [application package](https://github.com/spartango/TCGAIndex/releases/tag/1.0), and double click to run it.

You'll be able to choose a disease study from the TCGA right away. Once that's done, the Indexer will take a moment to scan the TCGA for slides and prepare a listing for you. When it's done, the Indexer will tell you how many slides it found, and where the list file can be found.

The output listings are tab-separated value text files, with three columns, in order:

* Patient Identifier (Site-Patient)
* Whether the tissue is a frozen section or FFPE slide
* The complete URL where the slide can be found

You can then bulk download slides using the list's third column. 

### Use as a Library

If you're a developer, you can include the [library](https://github.com/spartango/TCGAIndex/releases/tag/1.0) in your Java/JVM application.

From there, you can programmatically create the Indexer and use it:

	SlideIndex index = new SlideIndex(TCGAConstants.Bladder_Urothelial_Carcinoma, SlideIndex.FFPE_AND_FROZEN);

	// Examples of use
	Multimap<String, String> allSlides = index.getSlideUrls(); // Get all the slide urls, organized by patient
	Collection<String> patientSlides = index.getSlides(site, patient) // Get slide urls for a single patient
	Collection<String> siteSlides = index.getSlides(site) // Get slide urls for all patients of a single site

A full list of the disease studies in the TCGA can be found in TCGAConstants. 
Note also that you can restrict indexing to FFPE or Frozen slides alone. 

## Developer Stuff

You can build the source for this project using the [Gradle](http://www.gradle.org) build system. 