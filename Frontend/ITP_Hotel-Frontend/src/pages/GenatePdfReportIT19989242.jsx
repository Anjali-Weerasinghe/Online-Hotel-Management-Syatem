import React, { Component } from 'react';
import { Container } from 'react-bootstrap';
import SupplierService from '../adapters/SupplierServiceIT19989242';
import { Row,Col } from 'react-bootstrap';
import ReactToPrint from 'react-to-print';
import jsPDF from 'jspdf';  
import html2canvas from 'html2canvas'; 

class GenatePdfReport extends Component {
    constructor(props){
        super(props);

        this.state = {
           suppliers: []
        }
        this.addSupplier  = this.addSupplier.bind(this);
        this.editSupplier = this.editSupplier.bind(this);
        this.deleteSupplier = this.deleteSupplier.bind(this);

    }

    printDocument() {  
        const input = document.getElementById('pdfdiv');  
        html2canvas(input)  
          .then((canvas) => {  
            var imgWidth = 200;  
            var pageHeight = 290;  
            var imgHeight = canvas.height * imgWidth / canvas.width;  
            var heightLeft = imgHeight;  
            const imgData = canvas.toDataURL('image/png');  
            const pdf = new jsPDF('p', 'mm', 'a4')  
            var position = 0;  
            var heightLeft = imgHeight;  
            pdf.addImage(imgData, 'JPEG', 5, position, imgWidth, imgHeight);  
            pdf.save("download.pdf");  
          });  
    }  


    addSupplier(){
        this.props.history.push('/supplier');
    }
    viewSupplier(id){
        this.props.history.push(`/view-allsupplier/${id}`);
    }
    deleteSupplier(id){
        SupplierService.deleteSupplier(id).then( res => {
                this.setState({suppliers: this.state.suppliers.filter(supplier => supplier.sid !== id)});
        });
    }

    editSupplier(id){
        this.props.history.push(`/update-supplier/${id}`);
    }
    componentDidMount(){
        SupplierService.getSuppliers().then((res) =>{
            this.setState({ suppliers: res.data});

        });
    }
    render() {
        return (
            <div>
                
                <div className = "row">
                    {/* <button  className = "addbutton" style ={{marginBottom: "10px"},{marginLeft: "1px"}}  onClick ={this.addSupplier}>Add Supplier</button> */}
                    <button onClick={this.printDocument} variant="contained" style={{marginLeft:175}}  className = "addbutton" >  
                        Generate Report  
                                </button>  

                </div>
                <div className = "row"  id = "pdfdiv" style ={{marginTop: "10px", marginLeft: "-40px"}}>
                    <h2 className = "tableheading" style ={{marginLeft:200}} /*className = "text-center"*/><b>Suppliers List</b></h2>

                    <table className = "table table-striped table-bordered"  style ={{marginLeft:200}} className ="attendtable">
                        <thead>
                            <tr>
                                <th>Supplier ID</th>
                                <th>Name</th>
                                <th>Category</th>
                                <th>Email</th>
                                <th>NIC</th>
                                <th>Phone</th>
                                {/* <th>Actions</th> */}
                            </tr>
                        </thead>
                        <tbody>
                            {
                                this.state.suppliers.map(
                                    supplier =>
                                    <tr key = {supplier.sid}>
                                        <td>{supplier.sid}</td>
                                        <td>{supplier.name}</td>
                                        <td>{supplier.category}</td>
                                        <td>{supplier.email}</td>
                                        <td>{supplier.nic}</td>
                                        <td>{supplier.phone}</td>
                                        
                                        {/* <td>
                                            <Container> 
                                                <Row md = {4}>
                                                    <Col><button  className = "forminputbtn1" onClick = { () => this.editSupplier(supplier.sid)} >UPDATE</button></Col> 
                                                    <Col><button  onClick = { () => this.deleteSupplier(supplier.sid)} className = "forminputbtn2"  style ={{marginLeft: "25px"}} >DELETE</button></Col> 
                                                    <Col><button className = "forminputbtn1" style ={{marginLeft: "50px"}} onClick = { () => this.viewSupplier(supplier.sid)} >VIEW MORE..</button></Col>
                                                </Row>
                                             </Container>
                                        </td> */}

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


export default GenatePdfReport;