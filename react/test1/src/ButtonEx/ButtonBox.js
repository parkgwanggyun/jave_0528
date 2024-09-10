import { useState } from "react";

/*
    버튼 현재페이지/최대페이지 버튼
    으로 화면을 구성해서
    이전 버튼을 클릭하면 현재 페이지가 감속하고,
    다음 버튼을 크릭하면 현재 페이지가 증가하도록 작성
*/ 

function ButtonBox() {
    let [page, setPage] = useState(1);
    let maxPage =5;
function nextPage() {
    //다음 페이지로
    if(page<maxPage){
        setPage(page+1);
    }else{
        setPage(1);
    }
}
function prePage(){
    //이전 페이지로
    if(page>1){
        setPage(page-1);
    }else{
        setPage(maxPage);
    }
}
function movePage(amount){
    let currentPage = page + amount;
    if(currentPage == 0){
        currentPage = maxPage;
    }
    if(currentPage == maxPage+1){
        currentPage = 1;
    }
    setPage(currentPage);
}
    return(
        <div>           
            <div>
                <h3>movePage 함수를 이용</h3>
            <button onClick={()=>movePage(-1)}>&#60;</button>
            <span>{page}</span>
            <span>/</span>
            <span>{maxPage}</span>
            <button onClick={()=>movePage(1)}>&#62;</button>
            </div>
            <div>
            <h3>prePage와 nextPage 함수를 이용</h3>
            <button onClick={prePage}>&#60;</button>
            <span>{page}</span>
            <span>/</span>
            <span>{maxPage}</span>
            <button onClick={nextPage}>&#62;</button>
            </div>
        </div>
    )
}
export default ButtonBox;