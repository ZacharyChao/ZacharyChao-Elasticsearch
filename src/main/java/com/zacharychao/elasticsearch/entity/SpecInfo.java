package com.zacharychao.elasticsearch.entity;

import java.util.Date;
import java.util.List;


public class SpecInfo {
	
    private String specid;
	
    private String speccode;
	
    private String specname;
	
	
    private String specnameEn;
    private String spectype;
    private String status;
    
    private String state;
    
    private String revision;
    
    private String categorate;
    
    private String ics;
    
    private String ccs;
    
    private Date releasedate;
    
    private Date impdate;
    
    private String lastauditdate;
    
    private String auditresult;
    
    private String imporgnization;
    
    private String commitorgnization;
    
    private String comdepartment;
    
    private String draftperson;
    
    private String revieworgnization;
    
    private String contactperson;
    private String ontactphone;
    private String bulletinnumber;
    private Date bulletindate;
    private String bulletintitle;
    
    private String gdspProductcode;
    
    private String gdspProductname;
    
    private String gdspCode;
    
    private String source;
    
    private String gdspDept;
    
    private String categoryid;
    
    private String categoryname;
    
    private Date abolishdate;
    
    private Date replaceddate;
    
    private Boolean isteststandard;
    
    private Boolean isproductstandard;
    
    private String releaseorgnization;
    
    private String releasestatus;

    /**
     * 发布操作时间
     */
    private Date releasetime;

    /**
     * 发布操作人
     */
    private String releaseperson;
    
    private String resources;
    
    private String isdispatched;
    
    private String introduction;
    
    private String draftorgnization;
    
    private String comments;

    /**
     * 规范标准标志
     */
    private String exampleflag;
    
    /**
     * 不是数据库字段
     */
    private List<MethodClause> methodClauseList;
    

    public String getSpecid() {
        return specid;
    }

    public void setSpecid(String specid) {
        this.specid = specid;
    }

    public String getSpeccode() {
        return speccode;
    }

    public void setSpeccode(String speccode) {
        this.speccode = speccode;
    }

    public String getSpecname() {
        return specname;
    }

    public void setSpecname(String specname) {
        this.specname = specname;
    }

    public String getSpecnameEn() {
        return specnameEn;
    }

    public void setSpecnameEn(String specnameEn) {
        this.specnameEn = specnameEn;
    }

    public String getSpectype() {
        return spectype;
    }

    public void setSpectype(String spectype) {
        this.spectype = spectype;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getRevision() {
        return revision;
    }

    public void setRevision(String revision) {
        this.revision = revision;
    }

    public String getCategorate() {
        return categorate;
    }

    public void setCategorate(String categorate) {
        this.categorate = categorate;
    }

    public String getIcs() {
        return ics;
    }

    public void setIcs(String ics) {
        this.ics = ics;
    }

    public String getCcs() {
        return ccs;
    }

    public void setCcs(String ccs) {
        this.ccs = ccs;
    }

    public Date getReleasedate() {
        return releasedate;
    }

    public void setReleasedate(Date releasedate) {
        this.releasedate = releasedate;
    }

    public Date getImpdate() {
        return impdate;
    }

    public void setImpdate(Date impdate) {
        this.impdate = impdate;
    }

    public String getLastauditdate() {
        return lastauditdate;
    }

    public void setLastauditdate(String lastauditdate) {
        this.lastauditdate = lastauditdate;
    }

    public String getAuditresult() {
        return auditresult;
    }

    public void setAuditresult(String auditresult) {
        this.auditresult = auditresult;
    }

    public String getImporgnization() {
        return imporgnization;
    }

    public void setImporgnization(String imporgnization) {
        this.imporgnization = imporgnization;
    }

    public String getCommitorgnization() {
        return commitorgnization;
    }

    public void setCommitorgnization(String commitorgnization) {
        this.commitorgnization = commitorgnization;
    }

    public String getComdepartment() {
        return comdepartment;
    }

    public void setComdepartment(String comdepartment) {
        this.comdepartment = comdepartment;
    }

    public String getDraftperson() {
        return draftperson;
    }

    public void setDraftperson(String draftperson) {
        this.draftperson = draftperson;
    }

    public String getRevieworgnization() {
        return revieworgnization;
    }

    public void setRevieworgnization(String revieworgnization) {
        this.revieworgnization = revieworgnization;
    }

    public String getContactperson() {
        return contactperson;
    }

    public void setContactperson(String contactperson) {
        this.contactperson = contactperson;
    }

    public String getOntactphone() {
        return ontactphone;
    }

    public void setOntactphone(String ontactphone) {
        this.ontactphone = ontactphone;
    }

    public String getBulletinnumber() {
        return bulletinnumber;
    }

    public void setBulletinnumber(String bulletinnumber) {
        this.bulletinnumber = bulletinnumber;
    }

    public Date getBulletindate() {
        return bulletindate;
    }

    public void setBulletindate(Date bulletindate) {
        this.bulletindate = bulletindate;
    }

    public String getBulletintitle() {
        return bulletintitle;
    }

    public void setBulletintitle(String bulletintitle) {
        this.bulletintitle = bulletintitle;
    }

    public String getGdspProductcode() {
        return gdspProductcode;
    }

    public void setGdspProductcode(String gdspProductcode) {
        this.gdspProductcode = gdspProductcode;
    }

    public String getGdspProductname() {
        return gdspProductname;
    }

    public void setGdspProductname(String gdspProductname) {
        this.gdspProductname = gdspProductname;
    }

    public String getGdspCode() {
        return gdspCode;
    }

    public void setGdspCode(String gdspCode) {
        this.gdspCode = gdspCode;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getGdspDept() {
        return gdspDept;
    }

    public void setGdspDept(String gdspDept) {
        this.gdspDept = gdspDept;
    }

    public String getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(String categoryid) {
        this.categoryid = categoryid;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    public Date getAbolishdate() {
        return abolishdate;
    }

    public void setAbolishdate(Date abolishdate) {
        this.abolishdate = abolishdate;
    }

    public Date getReplaceddate() {
        return replaceddate;
    }

    public void setReplaceddate(Date replaceddate) {
        this.replaceddate = replaceddate;
    }

    public Boolean getIsteststandard() {
        return isteststandard;
    }

    public void setIsteststandard(Boolean isteststandard) {
        this.isteststandard = isteststandard;
    }

    public Boolean getIsproductstandard() {
        return isproductstandard;
    }

    public void setIsproductstandard(Boolean isproductstandard) {
        this.isproductstandard = isproductstandard;
    }

    public String getReleaseorgnization() {
        return releaseorgnization;
    }

    public void setReleaseorgnization(String releaseorgnization) {
        this.releaseorgnization = releaseorgnization;
    }

    public String getReleasestatus() {
        return releasestatus;
    }

    public void setReleasestatus(String releasestatus) {
        this.releasestatus = releasestatus;
    }

    public Date getReleasetime() {
        return releasetime;
    }

    public void setReleasetime(Date releasetime) {
        this.releasetime = releasetime;
    }

    public String getReleaseperson() {
        return releaseperson;
    }

    public void setReleaseperson(String releaseperson) {
        this.releaseperson = releaseperson;
    }

    public String getResources() {
        return resources;
    }

    public void setResources(String resources) {
        this.resources = resources;
    }

    public String getIsdispatched() {
        return isdispatched;
    }

    public void setIsdispatched(String isdispatched) {
        this.isdispatched = isdispatched;
    }

    public String getExampleflag() {
        return exampleflag;
    }

    public void setExampleflag(String exampleflag) {
        this.exampleflag = exampleflag;
    }

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getDraftorgnization() {
		return draftorgnization;
	}

	public void setDraftorgnization(String draftorgnization) {
		this.draftorgnization = draftorgnization;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
	
	

	public List<MethodClause> getMethodClauseList() {
		return methodClauseList;
	}

	public void setMethodClauseList(List<MethodClause> methodClauseList) {
		this.methodClauseList = methodClauseList;
	}

	@Override
	public String toString() {
		return "SpecInfo [specid=" + specid + ", speccode=" + speccode + ", specname=" + specname + ", specnameEn="
				+ specnameEn + ", spectype=" + spectype + ", status=" + status + ", state=" + state + ", revision="
				+ revision + ", categorate=" + categorate + ", ics=" + ics + ", ccs=" + ccs + ", releasedate="
				+ releasedate + ", impdate=" + impdate + ", lastauditdate=" + lastauditdate + ", auditresult="
				+ auditresult + ", imporgnization=" + imporgnization + ", commitorgnization=" + commitorgnization
				+ ", comdepartment=" + comdepartment + ", draftperson=" + draftperson + ", revieworgnization="
				+ revieworgnization + ", contactperson=" + contactperson + ", ontactphone=" + ontactphone
				+ ", bulletinnumber=" + bulletinnumber + ", bulletindate=" + bulletindate + ", bulletintitle="
				+ bulletintitle + ", gdspProductcode=" + gdspProductcode + ", gdspProductname=" + gdspProductname
				+ ", gdspCode=" + gdspCode + ", source=" + source + ", gdspDept=" + gdspDept + ", categoryid="
				+ categoryid + ", categoryname=" + categoryname + ", abolishdate=" + abolishdate + ", replaceddate="
				+ replaceddate + ", isteststandard=" + isteststandard + ", isproductstandard=" + isproductstandard
				+ ", releaseorgnization=" + releaseorgnization + ", releasestatus=" + releasestatus + ", releasetime="
				+ releasetime + ", releaseperson=" + releaseperson + ", resources=" + resources + ", isdispatched="
				+ isdispatched + ", introduction=" + introduction + ", draftorgnization=" + draftorgnization
				+ ", comments=" + comments + ", exampleflag=" + exampleflag + "]";
	}
    
    
    
    
}
