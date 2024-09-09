import React, { useState } from 'react';
    /*
    input창과 버튼,h1태그로 된 화면을 구성
    1. state변수 todo와 setTodo를 선언
    2. input창의 값이 바뀌면 콘솔에 1이 출력되게 작성
    3. 콘솔창에 1대신에 input창에 입력된값이 출력되도록 작성
    4. state변수 tmp와 setTmp를 선언
    5. input창에 입력된 값을 state변수 tmp에 업데이트
    6. 버튼을 클릭하면 콘솔에 2가 출력되게 작성
    7. 버튼을 클릭하면 state변수 todo의 값을 tmp의 값으로 업데이트
    8. h1태그에 todo의 값을 화면에 출력
*/
function Todo() {
    // state 변수 todo와 setTodo를 선언
    let [todo, setTodo] = useState("");
    let [tmp, setTmp] = useState("");

    function inputChange(e) {
        // 입력값을 state 변수 tmp에 업데이트
        setTmp(e.target.value);
        // 콘솔에 입력값 출력
        console.log(e.target.value);
    }

    function btnClick() {
        // 버튼 클릭 시 콘솔에 2 출력
        setTodo(tmp);
    }

    return (
        <div>
            <input onChange={inputChange} />
            <button onClick={btnClick}>버튼</button>
            <h1>{todo}</h1> {/* h1 태그에 state 변수 tmp의 값을 표시 */}
        </div>
    );
}

export default Todo;
