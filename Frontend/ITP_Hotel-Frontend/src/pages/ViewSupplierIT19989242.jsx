import React, { useEffect, Component } from 'react';
import { Container, FormControl, InputGroup } from 'react-bootstrap';
import SupplierService from '../adapters/SupplierServiceIT19989242';
import { Row,Col } from 'react-bootstrap';
import ReactToPrint from 'react-to-print';
import { Button } from 'bootstrap';




class ViewSupplier extends Component {
    constructor(props){
        super(props);

        this.state = {
           suppliers: [],
           searchId:''

           
        }
        this.addSupplier  = this.addSupplier.bind(this);
        this.editSupplier = this.editSupplier.bind(this);
        this.deleteSupplier = this.deleteSupplier.bind(this);
        this.generatepdfreport = this.generatepdfreport.bind(this);

    }

    

    addSupplier(){
        this.props.history.push('/supplier');
    }
    generatepdfreport(){
        this.props.history.push('/generatepdfreport');
    }
    viewSupplier(id){
        this.props.history.push(`/view-allsupplier/${id}`);
    }
    deleteSupplier(id){
        var confirmtext;
        if(window.confirm("Are You Sure Want to Delete !")){
            SupplierService.deleteSupplier(id).then( res => {
                this.setState({suppliers: this.state.suppliers.filter(supplier => supplier.sid !== id)});
                confirmtext = "You Successfully delete attendance";
                
            });
        }
        else{
            confirmtext = "You pressed cancel Try again";
        }
    }

    editSupplier(id){
        this.props.history.push(`/update-supplier/${id}`);
    }

    searchSupplierCategory(event){
        this.setState({ searchId: event.target.value.substr(0,
            20)});
    }


    componentDidMount(){
        SupplierService.getSuppliers().then((res) =>{
            this.setState({ suppliers: res.data});

        });
    }
    render() {
        let filtercategory = this.state.suppliers.filter((
            supplier)=>{
                return supplier.category.indexOf(this.state.
                    searchId)!==-1;
            }
        );

        return (
            <div>
                <h2 className = "tableheading" /*className = "text-center"*/><b>Suppliers List</b></h2>
                <div className = "row">
                    {/* <button  className = "addbutton" style ={{marginBottom: "10px"},{marginLeft: "1px"}}  onClick ={this.addSupplier}>Add Supplier</button> */}
                    <button onClick={this.generatepdfreport}  variant="contained"  className = "addbutton" >  
                        Generate Pdf  
                                </button>

                    <div class="form-group col-md-4">
                                
                                <input type="text" class="form-control" style={{marginLeft:550}} placeholder="Enter Supplier Category" value={this.state.searchId} onChange={this.searchSupplierCategory.bind(this)} />
                                
                    </div>


                </div>
                
                <div className = "row" style ={{marginTop: "10px", marginLeft: "-40px"}}>
                    <table className = "table table-striped table-bordered" id = "pdfdiv" className ="attendtable">
                        <thead>
                            <tr>
                                <th>Supplier ID</th>
                                <th>Name</th>
                                <th>Category</th>
                                <th>Email</th>
                                <th>NIC</th>
                                <th>Phone</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                filtercategory.map(
                                    supplier =>
                                    <tr key = {supplier.sid}>
                                        <td>{supplier.sid}</td>
                                        <td>{supplier.name}</td>
                                        <td>{supplier.category}</td>
                                        <td>{supplier.email}</td>
                                        <td>{supplier.nic}</td>
                                        <td>{supplier.phone}</td>
                                        
                                        <td>
                                            <Container> 
                                                <Row md = {4}>
                                                    <Col><button  className = "forminputbtn1" onClick = { () => this.editSupplier(supplier.sid)} >UPDATE</button></Col> 
                                                    <Col><button  onClick = { () => this.deleteSupplier(supplier.sid)} className = "forminputbtn2"  style ={{marginLeft: "25px"}} >DELETE</button></Col> 
                                                    <Col><button className = "forminputbtn1" style ={{marginLeft: "50px"}} onClick = { () => this.viewSupplier(supplier.sid)} >MORE..</button></Col>
                                                </Row>
                                             </Container>
                                        </td>

                                    </tr>
                                )
                            }
                            
                        </tbody>
                    </table>
                    
                </div>
    
            </div>
        );
    }
}


export default ViewSupplier;