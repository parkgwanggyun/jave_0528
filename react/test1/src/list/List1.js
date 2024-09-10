import { useState } from "react";
//다음과 같이 배열이 있을 때 배열을 이용해서 checkbox와 label태그로 된 화면을 구성하세요
   {/* {list.map((hobby, index) => (
                <label key={index}>
                    <input type="checkbox" value={hobby} />
                    {hobby}
                </label>
            ))} */}
function List1(){
    const list = ['축구','야구','농구','배구','음악감상']
    let [hobby,setHobby]=useState([]);
    let click = (e) => {
        const { value, checked } = e.target;
        let tmp = [...hobby];

        if (checked && hobby.length < 3) {
            tmp.push(value);
        } else if(!checked){
            tmp = tmp.filter(list => list !== value);
            //let index = tmp.indexOf(value);
            //tmp.splice(index,1);
        }else{
            alert('최대 3개까지 선택할 수 있습니다.')
        }

        setHobby(tmp);
    };
    let isDisabled = (value)=>{
        return hobby.length ==3 && !hobby.includes(value);
    }
    return(
        <div>
         
            <h1>당신의 취미는?</h1>
            {

            list.map((v,index)=>{
                return(
                    <label key={index}>
                        <input type="checkbox" value={v} onClick={click} disabled={isDisabled(v)}/>{v}
                    </label>
                )
            })
        }
        <ul>
            {
                hobby.map((v,index)=>{
                    return(
                        <li key={index}>{v}</li>
                    )
                })
            }
        </ul>
        </div>
    )
}
export default List1;