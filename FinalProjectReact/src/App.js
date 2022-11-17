import { Route, Switch } from "react-router-dom";
import './App.css';
import Layout from './components/layout/Layout';
import Home from './pages/Home';
import PersonApi from "./pages/PersonApi";

function App() {

  return (
   <Layout>
     <Switch>
        <Route path="/" exact>
          <Home/>
        </Route>
        <Route path="/api">
          <PersonApi/>
        </Route>
      </Switch>
   </Layout>
  );
}

export default App;