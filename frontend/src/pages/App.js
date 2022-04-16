import './App.css';
import {Grommet} from "grommet";
import React from "react";
import {TournamentsListPage} from "./tournaments-list";

function App() {
  return (
    <Grommet>
        <div className="App">
            <TournamentsListPage/>
        </div>
    </Grommet>
  );
}

export default App;
