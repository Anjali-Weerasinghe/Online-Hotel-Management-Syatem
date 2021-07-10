import logo from './logo.svg';
import './App.css';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom'
import ViewSupplier from './pages/ViewSupplierIT19989242';


import SupplierNavBar from './components/SupplierNavBarIT19989242';
import UpdateSupplier from './pages/UpdateSupplierIT19989242';
import ViewPurchasedItemDetail from './pages/ViewPurchasedItemDetailIT19989242';
import ViewSupplierComponent from './pages/ViewSupplierComponentIT19989242';
import UpdatePurchasedItemDetail from './pages/UpdatePurchasedItemDetailIT19989242';
import ViewPurchasedItemDetailComponent from './pages/ViewPurchasedItemDetailComponentIT19989242';
import AddNewSupplier from './pages/AddNewSupplierIT19989242';
import AddNewPurchasedItem from './pages/AddNewPurchasedItemIT19989242';
import GenatePdfReport from './pages/GenatePdfReportIT19989242';
import GeneratePdfReportItem from './pages/GeneratePdfReportItemIT19989242';




function App() {
  return (
  
    <div>
     
        <Router>
          <SupplierNavBar/> 
          
            <div className = "container">
              
                <Switch>
                  {/* <Route path = "/" exact component = {ViewSupplier}></Route> */}
                  {/* <Route path = "/view-supplier"  component = {ViewSupplier}></Route> */}
                  {/* <Route path = "/addsupplier" component = {AddSupplier}></Route> */}
                 
                  
                  {/* <Route path = "/update-supplier/:id"  component = {UpdateSupplier}></Route> */}
                  {/* <Route path = "/view-allsupplier/:id"  component = {ViewSupplierComponent}></Route> */}
                  {/* <ViewSupplier/>  */}
                  {/* <AddSupplier/> */}
                  {/* <ViewPurchasedItemDetail/> */}
                  <Route path = "/"  exact component = {ViewSupplier}></Route>
                  <Route path = "/view-supplier"  component = {ViewSupplier}></Route>
                  <Route path = "/view-purchaseditem"  component = {ViewPurchasedItemDetail}></Route> 
                  <Route path = "/update-purchaseditem/:id"  component = {UpdatePurchasedItemDetail}></Route>
                  <Route path = "/view-allpurchaseditem/:id"  component = {ViewPurchasedItemDetailComponent}></Route>
                  
                  <Route path = "/supplier" component = {AddNewSupplier}></Route>
                  <Route path = "/view-allsupplier/:id"  component = {ViewSupplierComponent}></Route>
                  <Route path = "/update-supplier/:id"  component = {UpdateSupplier}></Route>
                  <Route path = "/purchaseditem"  component = {AddNewPurchasedItem}></Route>
                  <Route path = "/generatepdfreport" component = {GenatePdfReport}></Route>
                  <Route path = "/generatepdfreportitem" component = {GeneratePdfReportItem}></Route>
                </Switch>
              
            </div>
          
        </Router>
      
    </div>
  
  );
}

export default App;
