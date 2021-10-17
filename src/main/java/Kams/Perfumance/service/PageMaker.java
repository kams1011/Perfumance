//package Kams.Perfumance.service;
//
//import Kams.Perfumance.vo.Criteria;
//import lombok.Getter;
//import lombok.Setter;
//
//
//@Getter
//@Setter
//public class PageMaker {
//
//
//    private Criteria cri;
//    private int totalCount;
//    private int startPage;
//    private int endPage;
//    private boolean prev;
//    private boolean next;
//    private int displayPageNum = 5;
//
//
//    public int getTotalCount() {
//        return totalCount;
//    }
//    public void setTotalCount(int totalCount) {
//        this.totalCount = totalCount;
//        calcData();
//    }
//
//    private void calcData() {
//
//        endPage = (int) (Math.ceil(cri.getPageNum() / (double) displayPageNum) * displayPageNum);
//
//        startPage = (endPage - displayPageNum) + 1;
//        if(startPage <= 0) startPage = 1;
//
//        int tempEndPage = (int) (Math.ceil(totalCount / (double) cri.getAmount()));
//        if (endPage > tempEndPage) {
//            endPage = tempEndPage;
//        }
//        prev = startPage == 1 ? false : true;
//        next = endPage * cri.getAmount()< totalCount ? true : false;
//    }
//
//}
//
//
//
