package entity;

import java.util.List;

public class PageModel<E> {
	private List<E> list;
	private int pageNo;
	private int pageSize;
	private int totalNum;
	private int totalPage;
	//�õ������ݼ�
	public List<E> getList() {
		return list;
	}
	public void setList(List<E> list) {
		this.list = list;
	}
	//�ڼ�ҳ
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	//ûҳ�Ĵ�С
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	//����������
	public int getTotalNum() {
		return totalNum;
	}
	public void setTotalNum(int totalNum){
		this.totalNum = totalNum;
		setTotalPage((getTotalNum() % pageSize) == 0 ?(getTotalNum()/pageSize):(getTotalNum()/pageSize + 1));
	}
	//��ҳ��
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	//��ȡ��һҳ
	public int getFirstPage(){
		return 1;
	}
	//��ȡ���һҳ
	public int getLastPage(){
		return totalPage;
	}
	//��ȡǰҳ
	public int getPrePage(){
		if(pageNo > 1){
			return (pageNo - 1);
		}
		return 1;
	}
	//��ȡ��һҳ
	public int getBackPage(){
		if(pageNo < totalPage){
			return pageNo + 1;
		}
		return totalPage;
	}
	//�ж���ҳ�Լ�ǰҳ�Ƿ����
	public String isPreable(){
		if(pageNo == 1){
			return "disable";
		}
		return "";
	}
	//�ж�βҳ�Լ���ҳ�Ƿ����
	public String isBackable(){
		if(pageNo == totalPage){
			return "disabled";
		}
		return "";
	}
}
