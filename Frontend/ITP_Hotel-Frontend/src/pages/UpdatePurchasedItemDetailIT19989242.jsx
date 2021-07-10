import React, { Component } from 'react';
import PurchasedItemDetailService from '../adapters/PurchasedItemDetailServiceIT19989242';
import { toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css'

toast.configure()
class UpdatePurchasedItemDetail extends Component {
    constructor(props){
        super(props)

        this.state = {
            invoiceNo: this.props.match.params.id,
            itemCode:'',
            itemName:'',
            categoty:'',
            description:'',
            date: '',
            sid: '',
            payment:'',
            
        }
        this.changeInvoiceNoHandler = this.changeInvoiceNoHandler.bind(this);
        this.changeItemCodeHandler = this.changeItemCodeHandler.bind(this);
        this.updatePurchasedItemDetail = this.updatePurchasedItemDetail.bind(this);
    }

    validate = () =>{
        
        let itemCodeError ="";
        let itemNameError ="";
       
        let descriptionError ="";
        let supplierIdError ="";
        let paymentError ="";

        
        if(!this.state.itemCode){
            itemCodeError  = 'Item Code is  is Required';
        }
        if(!this.state.itemName){
            itemNameError  = 'Item Name is Required';
        }
        
        if(!this.state.description){
            descriptionError  = 'description is Required';
        }
        if(!this.state.sid){
            supplierIdError  = 'Supplier Id is Required';
        }
        if(!this.state.payment){
            paymentError  = 'payment is Required';
        }
        if( itemCodeError || itemNameError  || descriptionError || supplierIdError || paymentError){
            this.setState({ itemCodeError, itemNameError,  descriptionError, supplierIdError, paymentError});
            return false;
        }

        return true;

    };
    notify(){
        toast.warn('Purchased Item Updated Successfully!', {position: toast.POSITION.TOP_CENTER})

    }




    componentDidMount(){
        PurchasedItemDetailService.getPurchasedItemDetailById(this.state.invoiceNo).then((res) => {
            let purchaseditemdetail = res.data;
            this.setState({invoiceNo:purchaseditemdetail.invoiceNo, itemCode: purchaseditemdetail.itemCode, itemName: purchaseditemdetail.itemName, category: purchaseditemdetail.it_Category, description: purchaseditemdetail.description, date: purchaseditemdetail.date, sid: purchaseditemdetail.sid, payment: purchaseditemdetail.payment })
        });
    } 
    updatePurchasedItemDetail = (e) => {
        e.preventDefault();
        const isValid = this.validate();
        if(isValid){

            let purchaseditemdetail = {invoiceNo:this.state.invoiceNo, itemCode:this.state.itemCode, itemName:this.state.itemName, it_Category:this.state.category, description:this.state.description,  sid: this.state.sid, payment: this.state.payment};
            console.log('purchaseditemdetail => ' + JSON.stringify(purchaseditemdetail));

            PurchasedItemDetailService.updatePurchasedItemDetail(purchaseditemdetail, this.state.invoiceNo).then( res =>{
                this.notify();
                this.props.history.push('/view-purchaseditem');
            });

        }
        
    }
    changeInvoiceNoHandler = (event) => {
        this.setState({invoiceNo: event.target.value});
    }
    changeItemCodeHandler = (event) => {
        this.setState({itemCode: event.target.value});
    }
    changeItemNameHandler = (event) => {
        this.setState({itemName: event.target.value});
    }
    changeCategoryHandler = (event) => {
        this.setState({category: event.target.value});
    }
    changeDescriptionHandler = (event) => {
        this.setState({description: event.target.value});
    }
   /* changeDateHandler = (event) => {
        this.setState({date: event.target.value});
    }*/
    changeSIDHandler = (event) => {
        this.setState({sid: event.target.value});
    }
    changePaymentHandler = (event) => {
        this.setState({payment: event.target.value});
    }
    render() {
        return (
            <div>
                <div className="container">
                    <div className="row" className="css">
                        <div className = "card col-md-6 offset-md-3 offset-md-3">
                            <h3 className = "text-center"><b>Update Purchased Item</b></h3>
                            <div className = "card-body">
                                <form>
                                    <div className = "form-group"> 
                                        <label>Invoice No:</label>
                                        <input placeholder = "Invoice No" name="invoiceNo" className = "form-control"
                                            value={this.state.invoiceNo} onChange={this.changeInvoiceNoHandler} readOnly/>
                                        
                                     </div> 
                                    <div className = "form-group">
                                        <label>Item Code:</label>
                                        <input placeholder = "Item Code" name="itemCode" className = "form-control"
                                            value={this.state.itemCode} onChange={this.changeItemCodeHandler}/>
                                        <div style ={{fontSize:"14px", color:"red"}}>{this.state.itemCodeError}</div>
                                    </div>
                                    <div className = "form-group">
                                        <label>Item Name:</label>
                                        <input  placeholder = "Item Name" name="itemName" className = "form-control"
                                            value={this.state.itemName} onChange={this.changeItemNameHandler}/>
                                        <div style ={{fontSize:"14px", color:"red"}}>{this.state.itemNameError}</div>
                                    </div>
                                    
                                    
                                    <div className = "form-group">
                                        <label>Category:</label>
                                        <select name = "category" className ="form-control" value ={this.state.category} onChange={this.changeCategoryHandler}>
                                            <option value ="furniture">Furniture</option>
                                            <option value ="decorationItems">Decoration Items</option>
                                            <option value ="electricalItems">Electrical Items</option>
                                            <option value ="kitchenItems">Kitchen Items</option>
                                            <option value ="cleaningProducts">Cleaning Products</option>

                                        </select>
                                        

                                    </div>
                                    <div className = "form-group">
                                        <label>Description:</label>
                                        <input placeholder = "Description" name="description" className = "form-control"
                                            value={this.state.description} onChange={this.changeDescriptionHandler}/>
                                            <div style ={{fontSize:"14px", color:"red"}}>{this.state.descriptionError}</div>
                                    </div>
                                    
                                    {/* <div className = "form-group"> 
                                       <label>Date:</label> 
                                        <input  placeholder = "Date"  name="date" className = "form-control" 
                                             value={this.state.date} /> 
                                    </div>  */}
                                    <div className = "form-group">
                                        <label>Supplier Id:</label>
                                        <input  placeholder = "Supplier Id"  name="sid" className = "form-control"
                                            value={this.state.sid} onChange={this.changeSIDHandler}/>
                                        <div style ={{fontSize:"14px", color:"red"}}>{this.state.supplierIdError}</div>
                                    </div>
                                    <div className = "form-group">
                                        <label>Payment:</label>
                                        <input  type = "number" placeholder = "Payment"  name="payment" className = "form-control"
                                            value={this.state.payment} onChange={this.changePaymentHandler}/>
                                        <div style ={{fontSize:"14px", color:"red"}}>{this.state.paymentError}</div>
                                    </div>
                                    
                                    <button type="submit" style = {{width:150}} className = "forminputbtn1" /*className = "btn btn-success"*/   onClick = {this.updatePurchasedItemDetail}>UPDATE</button>
                                    <button type="reset" className = "forminputbtn2" /*className = "btn btn-danger"*/ /*onClick = {this.cancel.bind(this)}*/ style={{marginLeft: "10px"}}>RESET</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                
            </div>
        );
    };
}

export default UpdatePurchasedItemDetail;