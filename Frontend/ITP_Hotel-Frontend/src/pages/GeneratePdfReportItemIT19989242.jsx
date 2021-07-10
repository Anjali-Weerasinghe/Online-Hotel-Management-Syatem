import React, { Component } from 'react';
import PurchasedItemDetailService from '../adapters/PurchasedItemDetailServiceIT19989242';
import { Container,Row, Col } from 'react-bootstrap';
import jsPDF from 'jspdf';  
import html2canvas from 'html2canvas'; 

class GeneratePdfReportItem extends Component {
    constructor(props){
        super(props);

        this.state = {
           purchaseditemdetails: []
        }
        this.editPurchasedItem = this.editPurchasedItem.bind(this);
        this.deletePurchasedItem = this.deletePurchasedItem.bind(this);
        this.ViewPurchasedItem = this. ViewPurchasedItem.bind(this);
        this.addPurchasedItem = this. addPurchasedItem.bind(this);
        

        
    }
    
    printDocument() {  
        const input = document.getElementById('pdfdiv1');  
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

    addPurchasedItem(){
        this.props.history.push('/purchaseditem');
    }
    deletePurchasedItem(id){
        PurchasedItemDetailService.deletePurchasedItemDetail(id).then(res =>{
            this.setState({purchaseditemdetails: this.state.purchaseditemdetails.filter (purchaseditemdetail => purchaseditemdetail.invoiceNo !==id)});
        })
    }
    editPurchasedItem(id){
        this.props.history.push(`/update-purchaseditem/${id}`);
    }
    ViewPurchasedItem(id){
        this.props.history.push(`/view-allpurchaseditem/${id}`);
    }
   
    componentDidMount(){
        PurchasedItemDetailService.getPurchasedItemDetail().then((res) =>{
            this.setState({ purchaseditemdetails: res.data});

        });
    }

    render() {
        return (
            <div>
                
                
                <div className = "row">
                   {/* <button  className = "addbutton" style ={{marginBottom: "10px"},{marginLeft: "-25px"}}  onClick ={this.addPurchasedItem}>Add Purchased Item</button> */}
                   <button onClick={this.printDocument} variant="contained" style={{marginLeft:80}}  className = "addbutton" >Generate Report </button>
                </div>
                <div className = "row" id  = "pdfdiv1" style ={{marginTop: "10px",marginLeft:"-65px"}}>
                    <h2 className = "tableheading" style={{marginLeft:130,width:1060}}><b>Purchased Items List</b></h2>
                    
                    
                    <table className = "table table-striped table-bordered"  style = {{marginLeft:130}} className ="attendtable">
                        
                        <thead>
                            <tr>

                                <th>Invoice No</th>
                                <th>Item Code</th>
                                <th>Name</th>
                                <th>Category</th>
                                <th>Description</th>
                                <th>Date</th>
                                <th>Supplier Id</th>
                                <th>Full Payment</th>
                                {/* <th>Actions</th> */}
                               
                            </tr>
                        </thead>
                        <tbody>
                            {
                                this.state.purchaseditemdetails.map(
                                    purchaseditemdetail =>
                                    <tr key = {purchaseditemdetail.invoiceNo}>
                                       <td>{purchaseditemdetail.invoiceNo}</td>
                                       <td>{purchaseditemdetail.itemCode}</td>
                                       <td>{purchaseditemdetail.itemName}</td>
                                       <td>{purchaseditemdetail.it_Category}</td>
                                       <td>{purchaseditemdetail.description}</td>
                                       <td>{purchaseditemdetail.date}</td>
                                       <td>{purchaseditemdetail.sid}</td>
                                       <td>{purchaseditemdetail.payment}</td>
                                       {/* <td>
                                            <Container>
                                                <Row md = {4}>
                                                    <Col><button className = "forminputbtn1" onClick = { () => this.editPurchasedItem(purchaseditemdetail.invoiceNo)} >UPDATE</button></Col>
                                                    <Col><button className = "forminputbtn2" style ={{marginLeft: "28px"}} onClick = { () => this.deletePurchasedItem(purchaseditemdetail.invoiceNo)} >DELETE</button></Col> 
                                                    <Col><button className = "forminputbtn1"style ={{marginLeft: "55px"}} onClick = { () => this.ViewPurchasedItem(purchaseditemdetail.invoiceNo)} >MORE..</button></Col>
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

export default GeneratePdfReportItem;