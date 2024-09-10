import { useState } from "react";

/*
    select 태그를 이용해서 과일을 선택할 수 있는 창을 만들고,
    과일을 선택하면 h1태그에 선택한 과일이 출력되도록 작성
    -선택안함, 사과,바나나,오렌지
*/ 
function Select() {
    let [fruit ,setFruit] = useState('선택안함');
    let change = (e)=> {
        setFruit(e.target.value)
    }
    return(
        <div>
        <h1>{fruit}</h1>
            <select onChange={change} value={fruit}>
                <option value={""}>선택안함</option>
                <option value="사과">사과</option>
                <option value="바나나">바나나</option>
                <option value="오렌지">오렌지</option>
            </select>
        </div>
    )   
}
export default Select;