package com.irislabs.tcga;

import com.google.common.collect.ImmutableMap;

import java.util.Map;

/**
 * Author: spartango
 * Date: 5/8/14
 * Time: 1:23 PM.
 */
public class TCGAConstants {
    // Codes and abbreviations can be found at https://tcga-data.nci.nih.gov/datareports/codeTablesReport.htm

    // Disease codes
    public static final String Acute_Myeloid_Leukemia                                           = "laml";
    public static final String Adrenocortical_carcinoma                                         = "acc";
    public static final String Bladder_Urothelial_Carcinoma                                     = "blca";
    public static final String Brain_Lower_Grade_Glioma                                         = "lgg";
    public static final String Breast_invasive_carcinoma                                        = "brca";
    public static final String Cervical_squamous_cell_carcinoma_and_endocervical_adenocarcinoma = "cesc";
    public static final String Cholangiocarcinoma                                               = "chol";
    public static final String Chronic_Myelogenous_Leukemia                                     = "lcml";
    public static final String Colon_adenocarcinoma                                             = "coad";
    public static final String Controls                                                         = "cntl";
    public static final String Esophageal_carcinoma_                                            = "esca";
    public static final String Glioblastoma_multiforme                                          = "gbm";
    public static final String Head_and_Neck_squamous_cell_carcinoma                            = "hnsc";
    public static final String Kidney_Chromophobe                                               = "kich";
    public static final String Kidney_renal_clear_cell_carcinoma                                = "kirc";
    public static final String Kidney_renal_papillary_cell_carcinoma                            = "kirp";
    public static final String Liver_hepatocellular_carcinoma                                   = "lihc";
    public static final String Lung_adenocarcinoma                                              = "luad";
    public static final String Lung_squamous_cell_carcinoma                                     = "lusc";
    public static final String Lymphoid_Neoplasm_Diffuse_Large_B_cell_Lymphoma                  = "dlbc";
    public static final String Mesothelioma                                                     = "meso";
    public static final String Miscellaneous                                                    = "misc";
    public static final String Ovarian_serous_cystadenocarcinoma                                = "ov";
    public static final String Pancreatic_adenocarcinoma                                        = "paad";
    public static final String Pheochromocytoma_and_Paraganglioma                               = "pcpg";
    public static final String Prostate_adenocarcinoma                                          = "prad";
    public static final String Rectum_adenocarcinoma                                            = "read";
    public static final String Sarcoma                                                          = "sarc";
    public static final String Skin_Cutaneous_Melanoma                                          = "skcm";
    public static final String Stomach_adenocarcinoma                                           = "stad";
    public static final String Testicular_Germ_Cell_Tumors                                      = "tgct";
    public static final String Thymoma                                                          = "thym";
    public static final String Thyroid_carcinoma                                                = "thca";
    public static final String Uterine_Carcinosarcoma                                           = "ucs";
    public static final String Uterine_Corpus_Endometrial_Carcinoma                             = "ucec";
    public static final String Uveal_Melanoma                                                   = "uvm";

    public static final Map<String, String> DISEASES = ImmutableMap.<String, String>builder()
                                                                   .put("Acute Myeloid Leukemia", "laml")
                                                                   .put("Adrenocortical carcinoma", "acc")
                                                                   .put("Bladder Urothelial Carcinoma", "blca")
                                                                   .put("Brain Lower Grade Glioma", "lgg")
                                                                   .put("Breast invasive carcinoma", "brca")
                                                                   .put("Cervical squamous cell carcinoma and endocervical adenocarcinoma",
                                                                        "cesc")
                                                                   .put("Cholangiocarcinoma", "chol")
                                                                   .put("Chronic Myelogenous Leukemia", "lcml")
                                                                   .put("Colon adenocarcinoma", "coad")
                                                                   .put("Controls", "cntl")
                                                                   .put("Esophageal carcinoma ", "esca")
                                                                   .put("Glioblastoma multiforme", "gbm")
                                                                   .put("Head and Neck squamous cell carcinoma", "hnsc")
                                                                   .put("Kidney Chromophobe", "kich")
                                                                   .put("Kidney renal clear cell carcinoma", "kirc")
                                                                   .put("Kidney renal papillary cell carcinoma", "kirp")
                                                                   .put("Liver hepatocellular carcinoma", "lihc")
                                                                   .put("Lung adenocarcinoma", "luad")
                                                                   .put("Lung squamous cell carcinoma", "lusc")
                                                                   .put("Lymphoid Neoplasm Diffuse Large B cell Lymphoma",
                                                                        "dlbc")
                                                                   .put("Mesothelioma", "meso")
                                                                   .put("Miscellaneous", "misc")
                                                                   .put("Ovarian serous cystadenocarcinoma", "ov")
                                                                   .put("Pancreatic adenocarcinoma", "paad")
                                                                   .put("Pheochromocytoma and Paraganglioma", "pcpg")
                                                                   .put("Prostate adenocarcinoma", "prad")
                                                                   .put("Rectum adenocarcinoma", "read")
                                                                   .put("Sarcoma", "sarc")
                                                                   .put("Skin Cutaneous Melanoma", "skcm")
                                                                   .put("Stomach adenocarcinoma", "stad")
                                                                   .put("Testicular Germ Cell Tumors", "tgct")
                                                                   .put("Thymoma", "thym")
                                                                   .put("Thyroid carcinoma", "thca")
                                                                   .put("Uterine Carcinosarcoma", "ucs")
                                                                   .put("Uterine Corpus Endometrial Carcinoma", "ucec")
                                                                   .put("Uveal Melanoma", "uvm")
                                                                   .build();
}
