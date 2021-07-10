import React, { Component } from 'react';
import PurchasedItemDetailService from '../adapters/PurchasedItemDetailServiceIT19989242';
import { Container,Row, Col } from 'react-bootstrap';

class ViewPurchasedItemDetail extends Component {
    constructor(props){
        super(props);

        this.state = {
           purchaseditemdetails: [],
           searchId:''
        }
        this.editPurchasedItem = this.editPurchasedItem.bind(this);
        this.deletePurchasedItem = this.deletePurchasedItem.bind(this);
        this.ViewPurchasedItem = this. ViewPurchasedItem.bind(this);
        this.addPurchasedItem = this. addPurchasedItem.bind(this);
        this.generatePdfReportItem = this.generatePdfReportItem.bind(this);

        
    }
    generatePdfReportItem(){
        this.props.history.push('/generatepdfreportitem');
    }


    addPurchasedItem(){
        this.props.history.push('/purchaseditem');
    }
    deletePurchasedItem(id){
        var confirmtext;
        if(window.confirm("Are You Sure Want to Delete !")){
            PurchasedItemDetailService.deletePurchasedItemDetail(id).then(res =>{
                this.setState({purchaseditemdetails: this.state.purchaseditemdetails.filter (purchaseditemdetail => purchaseditemdetail.invoiceNo !==id)});
                confirmtext = "You Successfully delete attendance";
            });
        }
        else{
            confirmtext = "You pressed cancel Try again";
        }
    }
    editPurchasedItem(id){
        this.props.history.push(`/update-purchaseditem/${id}`);
    }
    searchCategory(event){
        this.setState({ searchId: event.target.value.substr(0,
            20)});
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
        let filterit_Category = this.state.purchaseditemdetails.filter((
            purchaseditemdetail)=>{
                return purchaseditemdetail.it_Category.indexOf(this.state.
                    searchId)!==-1;
            }
        );

        return (
            <div>
                <h2 className = "tableheading"><b>Purchased Items List</b></h2>
                <div className = "row">
                   {/* <button  className = "addbutton" style ={{marginBottom: "10px"},{marginLeft: "-25px"}}  onClick ={this.addPurchasedItem}>Add Purchased Item</button> */}
                   <button onClick={this.generatePdfReportItem} style={{marginLeft:-25}} variant="contained"  className = "addbutton" >Generate Pdf </button>
                   <div class="form-group col-md-4">
                                
                                <input type="text" class="form-control" style={{marginLeft:580}} placeholder="Enter Item Category" value={this.state.searchId} onChange={this.searchCategory.bind(this)} />
                                
                    </div>
                </div>
                <div className = "row" style ={{marginTop: "10px",marginLeft:"-65px"}}>
                    <table className = "table table-striped table-bordered" className ="attendtable">
                        <thead>
                            <tr>

                                <th>Invoice No</th>
                                <th>Item Code</th>
                                <th>Name</th>
                                <th>Category</th>
                                {/* <th>Description</th> */}
                                <th>Date</th>
                                <th>Supplier Id</th>
                                <th>Full Payment</th>
                                <th>Actions</th>
                               
                            </tr>
                        </thead>
                        <tbody>
                            {
                                filterit_Category.map(
                                    purchaseditemdetail =>
                                    <tr key = {purchaseditemdetail.invoiceNo}>
                                       <td>{purchaseditemdetail.invoiceNo}</td>
                                       <td>{purchaseditemdetail.itemCode}</td>
                                       <td>{purchaseditemdetail.itemName}</td>
                                       <td>{purchaseditemdetail.it_Category}</td>
                                       {/* <td>{purchaseditemdetail.description}</td> */}
                                       <td>{purchaseditemdetail.date}</td>
                                       <td>{purchaseditemdetail.sid}</td>
                                       <td>{purchaseditemdetail.payment}</td>
                                       <td>
                                            <Container>
                                                <Row md = {4}>
                                                    <Col><button className = "forminputbtn1" onClick = { () => this.editPurchasedItem(purchaseditemdetail.invoiceNo)} >UPDATE</button></Col>
                                                    <Col><button className = "forminputbtn2" style ={{marginLeft: "28px"}} onClick = { () => this.deletePurchasedItem(purchaseditemdetail.invoiceNo)} >DELETE</button></Col> 
                                                    <Col><button className = "forminputbtn1"style ={{marginLeft: "55px"}} onClick = { () => this.ViewPurchasedItem(purchaseditemdetail.invoiceNo)} >MORE..</button></Col>
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

export default ViewPurchasedItemDetail;
