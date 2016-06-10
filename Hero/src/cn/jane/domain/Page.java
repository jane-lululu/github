package cn.jane.domain;

import java.util.List;/*
create table person(
			username char(12)
		);
*/
//�������������ҳ�йصĶ��Ҵ���Ҫ
public class Page {
	private List records;
	private int pagesize = 10;//ÿҳ��ʾ�ļ�¼����
	private int pagenum;//�û�Ҫ����ҳ�뼴��ǰҳ��
	private int totalpage;//��ҳ��
	private int startIndex;//ÿҳ��ʼ��¼������
	private int totalrecords;//�ܼ�¼����
	
	//��ʾ��ҳ��
	private int startPage;
	private int endPage;
	
	public Page(int pagenum,int totalrecords){
		this.pagenum = pagenum;
		this.totalrecords = totalrecords;
		
		//����ÿҳ��ʼ��¼������
		startIndex = (pagenum-1)*pagesize;
		//������ҳ��
		totalpage = totalrecords%pagesize==0?totalrecords/pagesize:(totalrecords/pagesize+1);
		
		//��ʾ��ҳ��
		if(totalpage<=9){
			startPage = 1;
			endPage = totalpage;
		}else{
			startPage = pagenum-4;
			endPage = pagenum+4;
			if(startPage<1){
				startPage = 1;
				endPage = 9;
			}
			if(endPage>totalpage){
				endPage = totalpage;
				startPage = totalpage-8;
			}
		}
	}
	
	
	public List getRecords() {
		return records;
	}
	public void setRecords(List records) {
		this.records = records;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public int getPagenum() {
		return pagenum;
	}
	public void setPagenum(int pagenum) {
		this.pagenum = pagenum;
	}
	public int getTotalpage() {
		return totalpage;
	}
	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}
	public int getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	public int getTotalrecords() {
		return totalrecords;
	}
	public void setTotalrecords(int totalrecords) {
		this.totalrecords = totalrecords;
	}


	public int getStartPage() {
		return startPage;
	}


	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}


	public int getEndPage() {
		return endPage;
	}


	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	
}
