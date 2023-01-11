import './App.css';
import List from "./page/List"
import {Route, Routes} from "react-router-dom";

function App() {
  return (
      <>

        <Routes>
          <Route path='/' element={<List/>}/>

        </Routes>

      </>

  );
}

export default App;
