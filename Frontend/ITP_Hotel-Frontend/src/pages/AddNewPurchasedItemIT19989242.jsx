import React, { Component } from 'react';
import PurchasedItemDetailService from '../adapters/PurchasedItemDetailServiceIT19989242';
import { toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css'

const initialState = {
    invoiceNo: '',
    itemCode: '',
    itemName: '',
    itCategory:'',
    description:'',
    sid:'',
    payment:''
}

toast.configure()
class AddNewPurchasedItem extends Component {
    constructor(props){
        super(props)

        this.state = initialState;

        this.changeInvoiceNoHandler= this.changeInvoiceNoHandler.bind(this);
        this.changeItemCodeHandler= this.changeItemCodeHandler.bind(this);
        this.changeItemNameHandler= this.changeItemNameHandler.bind(this);
        this.changeItemCategoryHandler= this.changeItemCategoryHandler.bind(this);
        this.changeDescriptionHandler= this.changeDescriptionHandler.bind(this);
        this.changeSupplierIdHandler= this.changeSupplierIdHandler.bind(this);
        this.changePaymentHandler= this.changePaymentHandler.bind(this);

    }

    notify(){
        toast.warn('Item Added Successfully!', {position: toast.POSITION.TOP_CENTER})

    }

    validate = () =>{
        let invoiceNoError ="";
        let itemCodeError ="";
        let itemNameError ="";
        let itCategoryError ="";
        let descriptionError ="";
        let supplierIdError ="";
        let paymentError ="";

        if(!this.state.invoiceNo){
            invoiceNoError  = 'Invoice Number is Required';
        }
        if(!this.state.itemCode){
            itemCodeError  = 'Item Code is  is Required';
        }
        if(!this.state.itemName){
            itemNameError  = 'Item Name is Required';
        }
        if(!this.state.itCategory){
            itCategoryError  = 'Item Category is Required';
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
        if(invoiceNoError || itemCodeError || itemNameError || itCategoryError || descriptionError || supplierIdError || paymentError){
            this.setState({invoiceNoError, itemCodeError, itemNameError, itCategoryError, descriptionError, supplierIdError, paymentError});
            return false;
        }

        return true;

    };

    handlesubmit = (e) => {
        e.preventDefault();
        const isValid = this.validate();
        if(isValid) {
            let purchaseditemdetail  = {invoiceNo:this.state.invoiceNo, itemCode:this.state.itemCode, itemName:this.state.itemName, it_Category: this.state.itCategory, description:this.state.description, sid:this.state.sid, payment:this.state.payment, "employee" :{"id":1} };
            console.log('purchaseditemdetail =>' +JSON.stringify(purchaseditemdetail));

            PurchasedItemDetailService.addPurchasedItem(purchaseditemdetail).then(res =>{
                this.notify();
                this.props.history.push('/view-purchaseditem');
            });


        }

    };
    changeInvoiceNoHandler = (event) => {
        this.setState({invoiceNo: event.target.value});
    }
    changeItemCodeHandler =(event) => {
        this.setState({itemCode: event.target.value});
    }
    changeItemNameHandler = (event) => {
        this.setState({itemName: event.target.value});
    }
    changeItemCategoryHandler = (event) => {
        this.setState({itCategory: event.target.value});
    }
    changeDescriptionHandler = (event) => {
        this.setState({description: event.target.value});
    }
    changeSupplierIdHandler = (event) => {
        this.setState({sid: event.target.value});
    }
    changePaymentHandler = (event) => {
        this.setState({payment: event.target.value});
    }
   
   
    cancel(){
        this.props.history.push('/employees')
    }
    render() {
        return (
            <div>
                <div className="container">
                    <div className="row" className = "css">
                        <div className = "card col-md-6 offset-md-3 offset-md-3">
                            <h3 className = "text-center"><b>ADD PURCHASED ITEM</b></h3>
                            <div className = "card-body">
                                <form  onSubmit ={this.handlesubmit}>
                                    <div className = "form-group">
                                        <label>Invoice No:</label>
                                        <input placeholder = "Invoice No" type ="number" name="invoiceNo" className = "form-control"
                                            value={this.state.invoiceNo} onChange={this.changeInvoiceNoHandler} />
                                        <div style ={{fontSize:"14px", color:"red"}}>{this.state.invoiceNoError}</div>
                                    </div>
                                    <div className = "form-group">
                                        <label>Item Code:</label>
                                        <input placeholder = "Item Code" name="itemCode" type="number" className = "form-control"
                                            value={this.state.itemCode} onChange={this.changeItemCodeHandler}/>
                                        <div style ={{fontSize:"14px", color:"red"}}>{this.state.itemCodeError}</div>
                                    </div>
                                    <div className = "form-group">
                                        <label>Item Name:</label>
                                        <input placeholder = "Item Name" name="itemName" className = "form-control"
                                            value={this.state.itemName} onChange={this.changeItemNameHandler}/>
                                        <div style ={{fontSize:"14px", color:"red"}}>{this.state.itemNameError}</div>
                                    </div>
                                    <div className = "form-group">
                                        <label> Item Category:</label>
                                        <select name = "itCategory" className ="form-control" value ={this.state.itCategory} onChange={this.changeItemCategoryHandler}>
                                            <option value ="CHOOSE">Choose</option>
                                            <option value ="furniture">Furniture</option>
                                            <option value ="decorationItems">Decoration Items</option>
                                            <option value ="electricalItems">Electrical Items</option>
                                            <option value ="kitchenItems">Kitchen Items</option>
                                            <option value ="cleaningProducts">Cleaning Products</option>

                                        </select>
                                       
                                        <div style ={{fontSize:"14px", color:"red"}}>{this.state.itCategoryError}</div>

                                    </div>
                                    <div className = "form-group">
                                        <label>Description:</label>
                                        <input placeholder = "Description" name="description" className = "form-control"
                                            value={this.state.description} onChange={this.changeDescriptionHandler}/>
                                        <div style ={{fontSize:"14px", color:"red"}}>{this.state.descriptionError}</div>
                                    </div>
                                    <div className = "form-group">
                                        <label>Supplier Id:</label>
                                        <input placeholder = "Supplier Id" name="supplierId" type="number" className = "form-control"
                                            value={this.state.supplierId} onChange={this.changeSupplierIdHandler}/>
                                        <div style ={{fontSize:"14px", color:"red"}}>{this.state.supplierIdError}</div>
                                    </div>
                                    <div className = "form-group">
                                        <label>Payment:</label>
                                        <input placeholder = "Payment" name="payment" className = "form-control"
                                            value={this.state.payment} onChange={this.changePaymentHandler} type="number"/>
                                        <div style ={{fontSize:"14px", color:"red"}}>{this.state.paymentError}</div>
                                    </div>
                                    
                                    
                                    
                                    
                                    

                                    <button type="submit" className = "forminputbtn1"/* "btn btn-success"*/   /*onClick = {this.saveSupplier}*/>ADD ITEM</button>
                                    <button className = "forminputbtn2"/*"btn btn-danger"*/ type = "reset" /*onClick = {this.cancel.bind(this)}*/ style={{marginLeft: "10px"}}>RESET</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                
            </div>
        );
    }
}

export default AddNewPurchasedItem;