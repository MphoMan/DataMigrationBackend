package com.example.DataMigration.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name="FY25")
public class PlanningData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private UUID id;
    private String newLinkNumber;
    @Column(name = "site_A_height")
    private String siteAHeight;
    @Column(name = "site_B_height")
    private String siteBHeight;
    private String channels;
    private String destinationSite;
    private String subBand;
    private String hopLengthKm;
    private String newConfig;
    @Column(name = "thermal_fade_margin_B")
    private String thermalFadeMarginB;
    private String region;
    private String budget;
    @Column(name = "availability_A")
    private String availabilityA;
    private String sourceSite;
    @Column(name = "thermal_fade_margin_A")
    private String thermalFadeMarginA;
    @Column(name = "availability_B")
    private String availabilityB;
    @Column(name = "A_toll_id_site_B")
    private String atollIdSiteB;
    private String approval;
    private String listName;
    @Column(name = "A_toll_id_site_A")
    private String atollIdSiteA;
    private String fileChecksum;

    public PlanningData() {
    }

    public PlanningData(UUID id,
                        String newLinkNumber,
                        String siteAHeight,
                        String siteBHeight,
                        String channels,
                        String destinationSite,
                        String subBand,
                        String hopLengthKm,
                        String newConfig,
                        String thermalFadeMarginB,
                        String region,
                        String budget,
                        String availabilityA,
                        String sourceSite,
                        String thermalFadeMarginA,
                        String availabilityB,
                        String atollIdSiteB,
                        String approval,
                        String listName,
                        String atollIdSiteA,
                        String fileChecksum) {
        this.id = id;
        this.newLinkNumber = newLinkNumber;
        this.siteAHeight = siteAHeight;
        this.siteBHeight = siteBHeight;
        this.channels = channels;
        this.destinationSite = destinationSite;
        this.subBand = subBand;
        this.hopLengthKm = hopLengthKm;
        this.newConfig = newConfig;
        this.thermalFadeMarginB = thermalFadeMarginB;
        this.region = region;
        this.budget = budget;
        this.availabilityA = availabilityA;
        this.sourceSite = sourceSite;
        this.thermalFadeMarginA = thermalFadeMarginA;
        this.availabilityB = availabilityB;
        this.atollIdSiteB = atollIdSiteB;
        this.approval = approval;
        this.listName = listName;
        this.atollIdSiteA = atollIdSiteA;
        this.fileChecksum = fileChecksum;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNewLinkNumber() {
        return newLinkNumber;
    }

    public void setNewLinkNumber(String newLinkNumber) {
        this.newLinkNumber = newLinkNumber;
    }

    public String getSiteAHeight() {
        return siteAHeight;
    }

    public void setSiteAHeight(String siteAHeight) {
        this.siteAHeight = siteAHeight;
    }

    public String getSiteBHeight() {
        return siteBHeight;
    }

    public void setSiteBHeight(String siteBHeight) {
        this.siteBHeight = siteBHeight;
    }

    public String getChannels() {
        return channels;
    }

    public void setChannels(String channels) {
        this.channels = channels;
    }

    public String getDestinationSite() {
        return destinationSite;
    }

    public void setDestinationSite(String destinationSite) {
        this.destinationSite = destinationSite;
    }

    public String getSubBand() {
        return subBand;
    }

    public void setSubBand(String subBand) {
        this.subBand = subBand;
    }

    public String getHopLengthKm() {
        return hopLengthKm;
    }

    public void setHopLengthKm(String hopLengthKm) {
        this.hopLengthKm = hopLengthKm;
    }

    public String getNewConfig() {
        return newConfig;
    }

    public void setNewConfig(String newConfig) {
        this.newConfig = newConfig;
    }

    public String getThermalFadeMarginB() {
        return thermalFadeMarginB;
    }

    public void setThermalFadeMarginB(String thermalFadeMarginB) {
        this.thermalFadeMarginB = thermalFadeMarginB;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public String getAvailabilityA() {
        return availabilityA;
    }

    public void setAvailabilityA(String availabilityA) {
        this.availabilityA = availabilityA;
    }

    public String getSourceSite() {
        return sourceSite;
    }

    public void setSourceSite(String sourceSite) {
        this.sourceSite = sourceSite;
    }

    public String getThermalFadeMarginA() {
        return thermalFadeMarginA;
    }

    public void setThermalFadeMarginA(String thermalFadeMarginA) {
        this.thermalFadeMarginA = thermalFadeMarginA;
    }

    public String getAvailabilityB() {
        return availabilityB;
    }

    public void setAvailabilityB(String availabilityB) {
        this.availabilityB = availabilityB;
    }

    public String getAtollIdSiteB() {
        return atollIdSiteB;
    }

    public void setAtollIdSiteB(String atollIdSiteB) {
        this.atollIdSiteB = atollIdSiteB;
    }

    public String getApproval() {
        return approval;
    }

    public void setApproval(String approval) {
        this.approval = approval;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public String getAtollIdSiteA() {
        return atollIdSiteA;
    }

    public void setAtollIdSiteA(String atollIdSiteA) {
        this.atollIdSiteA = atollIdSiteA;
    }

    public String getFileChecksum() {
        return fileChecksum;
    }

    public void setFileChecksum(String fileChecksum) {
        this.fileChecksum = fileChecksum;
    }

    @Override
    public String toString() {
        return "PlanningData{" +
                "id=" + id +
                ", newLinkNumber='" + newLinkNumber + '\'' +
                ", siteAHeight='" + siteAHeight + '\'' +
                ", siteBHeight='" + siteBHeight + '\'' +
                ", channels='" + channels + '\'' +
                ", destinationSite='" + destinationSite + '\'' +
                ", subBand='" + subBand + '\'' +
                ", hopLengthKm='" + hopLengthKm + '\'' +
                ", newConfig='" + newConfig + '\'' +
                ", thermalFadeMarginB='" + thermalFadeMarginB + '\'' +
                ", region='" + region + '\'' +
                ", budget='" + budget + '\'' +
                ", availabilityA='" + availabilityA + '\'' +
                ", sourceSite='" + sourceSite + '\'' +
                ", thermalFadeMarginA='" + thermalFadeMarginA + '\'' +
                ", availabilityB='" + availabilityB + '\'' +
                ", atollIdSiteB='" + atollIdSiteB + '\'' +
                ", approval='" + approval + '\'' +
                ", listName='" + listName + '\'' +
                ", atollIdSiteA='" + atollIdSiteA + '\'' +
                ", fileChecksum='" + fileChecksum + '\'' +
                '}';
    }
}
