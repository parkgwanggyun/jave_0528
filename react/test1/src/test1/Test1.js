import Ul from "./Ul";

/*
    오늘의 할일 ul태그와 li태그로 구성하여 화면에 출력하는 컴포넌트
    ul태그를 위해서 ul컴포넌트,li태그를 위해서 Li컴포넌트를 생성하여 작성
 */
function Test1() {
    return(
        <div>
            <span>오늘의 할일</span>
            <Ul/>
        </div>
    )
}

export default Test1();