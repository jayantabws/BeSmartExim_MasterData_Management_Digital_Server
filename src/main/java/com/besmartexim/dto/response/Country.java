package com.besmartexim.dto.response;

import java.util.Date;

import javax.persistence.Column;

public class Country {
	
	private Long id;
	private Long continentId;
	private String isExport;
	private String isImport;
	private String name;
	private String shortcode;
	private String description;
	private String image;
	private String sampleFileImport;
	private String sampleFileExport;
	private String isActive;
	private Date createdDate;
	private Date exportFrom;
	private Date exportUpto;
	private Long exportRecords;
	private Date importFrom;
	private Date importUpto;
	private Long importRecords;
	private Long importPointWeightage;
	private Long exportPointWeightage;
	private String exporterForImport;
	private String importerForExport;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getContinentId() {
		return continentId;
	}
	public void setContinentId(Long continentId) {
		this.continentId = continentId;
	}
	public String getIsExport() {
		return isExport;
	}
	public void setIsExport(String isExport) {
		this.isExport = isExport;
	}
	public String getIsImport() {
		return isImport;
	}
	public void setIsImport(String isImport) {
		this.isImport = isImport;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getShortcode() {
		return shortcode;
	}
	public void setShortcode(String shortcode) {
		this.shortcode = shortcode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getSampleFileImport() {
		return sampleFileImport;
	}
	public void setSampleFileImport(String sampleFileImport) {
		this.sampleFileImport = sampleFileImport;
	}
	public String getSampleFileExport() {
		return sampleFileExport;
	}
	public void setSampleFileExport(String sampleFileExport) {
		this.sampleFileExport = sampleFileExport;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getExportFrom() {
		return exportFrom;
	}
	public void setExportFrom(Date exportFrom) {
		this.exportFrom = exportFrom;
	}
	public Date getExportUpto() {
		return exportUpto;
	}
	public void setExportUpto(Date exportUpto) {
		this.exportUpto = exportUpto;
	}
	public Long getExportRecords() {
		return exportRecords;
	}
	public void setExportRecords(Long exportRecords) {
		this.exportRecords = exportRecords;
	}
	public Date getImportFrom() {
		return importFrom;
	}
	public void setImportFrom(Date importFrom) {
		this.importFrom = importFrom;
	}
	public Date getImportUpto() {
		return importUpto;
	}
	public void setImportUpto(Date importUpto) {
		this.importUpto = importUpto;
	}
	public Long getImportRecords() {
		return importRecords;
	}
	public void setImportRecords(Long importRecords) {
		this.importRecords = importRecords;
	}
	public Long getImportPointWeightage() {
		return importPointWeightage;
	}
	public void setImportPointWeightage(Long importPointWeightage) {
		this.importPointWeightage = importPointWeightage;
	}
	public Long getExportPointWeightage() {
		return exportPointWeightage;
	}
	public void setExportPointWeightage(Long exportPointWeightage) {
		this.exportPointWeightage = exportPointWeightage;
	}
	public String getExporterForImport() {
		return exporterForImport;
	}
	public void setExporterForImport(String exporterForImport) {
		this.exporterForImport = exporterForImport;
	}
	public String getImporterForExport() {
		return importerForExport;
	}
	public void setImporterForExport(String importerForExport) {
		this.importerForExport = importerForExport;
	}
	
	
	
}
