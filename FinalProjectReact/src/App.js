import { Route, Switch } from "react-router-dom";
import './App.css';
import Layout from './components/layout/Layout';
import Home from './pages/Home';

function App() {

  return (
   <Layout>
     <Switch>
        <Route path="/" exact>
          <Home/>
        </Route>
      </Switch>
   </Layout>
  );
}

export default App;