package com.besmartexim.database.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mst_country")
public class MstCountry {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "continent_id")
	private Long continentId;

	@Column(name = "is_export")
	private String isExport;

	@Column(name = "is_import")
	private String isImport;

	@Column(name = "name")
	private String name;

	@Column(name = "shortcode")
	private String shortcode;

	@Column(name = "description")
	private String description;

	@Column(name = "image")
	private String image;

	@Column(name = "sample_file_import")
	private String sampleFileImport;

	@Column(name = "sample_file_export")
	private String sampleFileExport;

	@Column(name = "is_active")
	private String isActive;

	@Column(name = "created_by")
	private Long createdBy;

	@Column(name = "created_date")
	private Date createdDate;

	@Column(name = "modified_by")
	private Long modifiedBy;

	@Column(name = "modified_date")
	private Date modifiedDate;

	@Column(name = "export_from")
	private Date exportFrom;

	@Column(name = "export_upto")
	private Date exportUpto;

	@Column(name = "export_records")
	private Long exportRecords;

	@Column(name = "import_from")
	private Date importFrom;

	@Column(name = "import_upto")
	private Date importUpto;

	@Column(name = "import_records")
	private Long importRecords;

	@Column(name = "import_point")
	private Long importPointWeightage;

	@Column(name = "export_point")
	private Long exportPointWeightage;

	@Column(name = "exporter_for_import")
	private String exporterForImport;

	@Column(name = "importer_for_export")
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

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Long getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Long modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
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
