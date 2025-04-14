package api.payload;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class stoDetails {
	
	
	LocalDateTime fromDateStr = LocalDateTime.now().minusDays(7); // 7 days ago
	LocalDateTime toDateStr = LocalDateTime.now();                // current time

	
	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy'T'HH:mm:ss");
	String stoNos[];
	Date stoFromDate;
	Date stoToDate;		
	String srcLocation;
	String stoType[];
	String status[];
	String destLocation;
	int pageNumber;	

	
	public LocalDateTime getFromDateStr() {
		return fromDateStr;
	}
	public void setFromDateStr(LocalDateTime fromDateStr) {
		this.fromDateStr = fromDateStr;
	}
	public LocalDateTime getToDateStr() {
		return toDateStr;
	}
	public void setToDateStr(LocalDateTime toDateStr) {
		this.toDateStr = toDateStr;
	}
	public String[] getStoNos() {
		return stoNos;
	}
	public void setStoNos(String[] stoNos) {
		this.stoNos = stoNos;
	}
	public Date getStoFromDate() {
		return stoFromDate;
	}
	public void setStoFromDate(Date stoFromDate) {
		this.stoFromDate = stoFromDate;
	}
	public Date getStoToDate() {
		return stoToDate;
	}
	public void setStoToDate(Date stoToDate) {
		this.stoToDate = stoToDate;
	}
	public String getSrcLocation() {
		return srcLocation;
	}
	public void setSrcLocation(String srcLocation) {
		this.srcLocation = srcLocation;
	}
	public String[] getStoType() {
		return stoType;
	}
	public void setStoType(String[] stoType) {
		this.stoType = stoType;
	}
	public String[] getStatus() {
		return status;
	}
	public void setStatus(String[] status) {
		this.status = status;
	}
	public String getDestLocation() {
		return destLocation;
	}
	public void setDestLocation(String destLocation) {
		this.destLocation = destLocation;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	
	
	
	
	

	
	
	
}
