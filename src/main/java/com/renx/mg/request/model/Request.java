package com.renx.mg.request.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Request {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	private Long serviceCategoryId;
	private Long serviceSubCategoryId;
	private String location;
	private String description;
	private Long siteId;
	private Long userId;
	private RequestStatusType requestStatus;
	
	@OneToOne
	@JoinColumn(name = "serviceCategoryId", referencedColumnName = "id", unique = true, nullable = true,
	updatable = false, insertable = false)
	private ServiceCategory serviceCategory;
	
	@OneToOne
	@JoinColumn(name = "serviceSubCategoryId", referencedColumnName = "id", unique = true, nullable = true,
	updatable = false, insertable = false)
	private ServiceSubCategory serviceSubCategory;
	
	@OneToOne
	@JoinColumn(name = "siteId", referencedColumnName = "id", unique = true, nullable = true,
	updatable = false, insertable = false)
	private Site site;
	
	@OneToOne
	@JoinColumn(name = "userId", referencedColumnName = "id", unique = true, nullable = true,
	updatable = false, insertable = false)
	private User user;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getServiceCategoryId() {
		return serviceCategoryId;
	}
	public void setServiceCategoryId(Long serviceCategoryId) {
		this.serviceCategoryId = serviceCategoryId;
	}
	public Long getServiceSubCategoryId() {
		return serviceSubCategoryId;
	}
	public void setServiceSubCategoryId(Long serviceSubCategoryId) {
		this.serviceSubCategoryId = serviceSubCategoryId;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getSiteId() {
		return siteId;
	}
	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public RequestStatusType getRequestStatus() {
		return requestStatus;
	}
	public void setRequestStatus(RequestStatusType requestStatus) {
		this.requestStatus = requestStatus;
	}
	public ServiceCategory getServiceCategory() {
		return serviceCategory;
	}
	public void setServiceCategory(ServiceCategory serviceCategory) {
		this.serviceCategory = serviceCategory;
	}
	public ServiceSubCategory getServiceSubCategory() {
		return serviceSubCategory;
	}
	public void setServiceSubCategory(ServiceSubCategory serviceSubCategory) {
		this.serviceSubCategory = serviceSubCategory;
	}
	public Site getSite() {
		return site;
	}
	public void setSite(Site site) {
		this.site = site;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	

	
}
