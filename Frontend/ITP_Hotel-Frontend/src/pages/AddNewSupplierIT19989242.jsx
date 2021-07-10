import React, { Component } from 'react';
import SupplierService from '../adapters/SupplierServiceIT19989242'; 
import { toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css'

const initialState = {
    supplierId:'',
    name: '',
    emailId:'',
    nic:'',
    phone:'',
    category:'',
    supplierIdError:'',
    nameError: '',
    emailIdError: '',
    nicError: '',
    phoneError: '',
    categoryError: ''

}


toast.configure()
class AddNewSupplier extends Component {
    constructor(props){
        super(props)

        this.state =initialState;

        this.changeSupplierIDHandler = this.changeSupplierIDHandler.bind(this);
        this.changeNameHandler = this.changeNameHandler.bind(this);
        this.changeEmailIdHandler = this.changeEmailIdHandler.bind(this);
        this.changeNICHandler = this.changeNICHandler.bind(this);
        this.changePhoneHandler = this.changePhoneHandler.bind(this);
        this.changeCategoryHandler = this.changeCategoryHandler.bind(this);

        // this.saveSupplier = this.saveSupplier.bind(this);
    }

    notify(){
        toast.warn('Supplier Added Successfully!', {position: toast.POSITION.TOP_CENTER})

    }
    validate = () =>{

            let supplierIdError = "";
            let nameError =  "";
            let emailIdError =  "";
            let nicError =  "";
            let phoneError =  "";
            let categoryError =  "";

            if(!this.state.emailId.includes('@')){
                emailIdError = 'Invalid Email';
            }
            if(!this.state.emailId) {
                emailIdError = 'Email is Required';
            }
            if(!this.state.supplierId) {
                supplierIdError = 'Supplier id is Required';
            }
            if(!this.state.name) {
                nameError = 'Name is Required';
            }
            if(!this.state.nic) {
                nicError = 'NIC is Required';
            }
            if(!this.state.phone) {
                phoneError = 'Phone is Required';
            }
            if(!this.state.category) {
                categoryError = 'Category is Required';
            }
            if (emailIdError || supplierIdError || nameError || nicError || phoneError || categoryError){
                this.setState({emailIdError , supplierIdError, nameError, nicError, phoneError, categoryError});
                return false;
            }

            return true;


    };

    handlesubmit  = (e) => {
        e.preventDefault();
        const isValid = this.validate();
        if(isValid) {

            let supplier = {sid:this.state.supplierId, name:this.state.name, email:this.state.emailId, nic:this.state.nic, phone:this.state.phone, category:this.state.category,  "employee" :{"id":1}};
            console.log('supplier => ' + JSON.stringify(supplier));

            SupplierService.addSupplier(supplier).then(res =>{
                this.notify();
                this.props.history.push('/view-supplier');
            });
        }
       /* let supplier = {sid:this.state.supplierId, name:this.state.name, email:this.state.emailId, nic:this.state.nic, phone:this.state.phone, category:this.state.category, password: this.state.password2, "employee" :{"id":1}};
        console.log('supplier => ' + JSON.stringify(supplier));

        SupplierService.addSupplier(supplier).then(res =>{
                this.props.history.push('/view-supplier');
        });*/
    };
 
    changeSupplierIDHandler = (event) => {
        this.setState({supplierId: event.target.value});
    }
    changeNameHandler =(event) => {
        this.setState({name: event.target.value});
    }
    changeEmailIdHandler = (event) => {
        this.setState({emailId: event.target.value});
    }
    changeNICHandler = (event) => {
        this.setState({nic: event.target.value});
    }
    changePhoneHandler = (event) => {
        this.setState({phone: event.target.value});
    }
    changeCategoryHandler = (event) => {
        this.setState({category: event.target.value});
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
                            <h3 className = "text-center"><b>ADD
                                 SUPPLIER</b></h3>
                            <div className = "card-body">
                                <form  onSubmit ={this.handlesubmit}>
                                    <div className = "form-group">
                                        <label>Supplier ID:</label>
                                        <input placeholder = "Supplier ID" name="supplierId" className = "form-control"
                                            value={this.state.supplierId} onChange={this.changeSupplierIDHandler} />
                                        <div style ={{fontSize:"14px", color:"red"}}>{this.state.supplierIdError}</div>
                                    </div>
                                    <div className = "form-group">
                                        <label>Name:</label>
                                        <input placeholder = "Name" name="name" className = "form-control"
                                            value={this.state.name} onChange={this.changeNameHandler}/>
                                        <div style ={{fontSize:"14px", color:"red"}}>{this.state.nameError}</div>
                                    </div>
                                    <div className = "form-group">
                                        <label>Email Id:</label>
                                        <input placeholder = "EmailId" name="emailId" className = "form-control"
                                            value={this.state.emailId} onChange={this.changeEmailIdHandler}/>
                                        <div style ={{fontSize:"14px", color:"red"}}>{this.state.emailIdError}</div>
                                    </div>
                                    <div className = "form-group">
                                        <label>NIC:</label>
                                        <input placeholder = "NIC" name="nic" className = "form-control"
                                            value={this.state.nic} onChange={this.changeNICHandler}/>
                                        <div style ={{fontSize:"14px", color:"red"}}>{this.state.nicError}</div>
                                    </div>
                                    <div className = "form-group">
                                        <label>Phone:</label>
                                        <input type = "tel" placeholder = "Phone" name="phone" className = "form-control"
                                            value={this.state.phone} onChange={this.changePhoneHandler} pattern ="[0-9]{10}" maxLength = "10"/>
                                        <div style ={{fontSize:"14px", color:"red"}}>{this.state.phoneError}</div>
                                    </div>
                                    
                                    
                                    <div className = "form-group">
                                        <label>Category:</label>
                                        <select name = "category" className ="form-control" value ={this.state.category} onChange={this.changeCategoryHandler}>
                                            <option value ="CHOOSE">Choose</option>
                                            <option value ="furniture">Furniture</option>
                                            <option value ="decorationItems">Decoration Items</option>
                                            <option value ="electricalItems">Electrical Items</option>
                                            <option value ="kitchenItems">Kitchen Items</option>
                                            <option value ="cleaningProducts">Cleaning Products</option>

                                        </select>
                                        <div style ={{fontSize:"14px", color:"red"}}>{this.state.categoryError}</div>

                                    </div>
                                    

                                    <button type="submit" style = {{width:150}}className = "forminputbtn1"/*"btn btn-success" */  /*onClick = {this.saveSupplier}*/>ADD SUPPLIER</button>
                                    <button className = "forminputbtn2"/*"btn btn-danger"*/ type = "reset" /*onClick = {this.cancel.bind(this)}*/ style={{marginLeft: "10px"}}>RESET</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}
export default AddNewSupplier;