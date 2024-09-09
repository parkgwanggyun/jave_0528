
import './App.css';
import TodoList from './TodoList/TodoList';
//import Test1 from './test1/Test1';
//import Todo from './Todo/Todo';

function App(props) {
  return (
    <div>
      <span>오늘의 할일</span>
      {/* <Test1/> */}
      {/* <Todo/> */}
      <TodoList/>
    </div>
  );
}

export default App;
