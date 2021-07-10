import React, { Component } from 'react';
import SupplierService from '../adapters/SupplierServiceIT19989242';
import { toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css'

toast.configure()
class UpdateSupplier extends Component {
    constructor(props){
        super(props)

        this.state = {
            sid: this.props.match.params.id,
            name: '',
            emailId:'',
            nic:'',
            phone:'',
            category:'',
            password:'',
           

        } 
    
        this.changeSupplierIdHandler = this.changeSupplierIdHandler.bind(this);
        this.changeNameHandler = this.changeNameHandler.bind(this);
        this.updateSupplier = this.updateSupplier.bind(this);
    }
    notify(){
        toast.warn('Supplier Updated Successfully!', {position: toast.POSITION.TOP_CENTER})

    }

    validate = () =>{

        
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
        if (emailIdError ||  nameError || nicError || phoneError || categoryError){
            this.setState({emailIdError , nameError, nicError, phoneError, categoryError});
            return false;
        }

        return true;


    };


    componentDidMount(){
        SupplierService.getSupplierById(this.state.sid).then((res) => {
            let supplier = res.data;
            this.setState({sid:supplier.sid,name: supplier.name, emailId: supplier.email, nic: supplier.nic, phone: supplier.phone, category: supplier.category, password: supplier.password})
        });
    }
    updateSupplier  = (e) => {
        e.preventDefault();
        const isValid = this.validate();
        if(isValid){

            let supplier = {sid:this.state.sid, name:this.state.name, email:this.state.emailId, nic:this.state.nic, phone:this.state.phone, category:this.state.category, password: this.state.password};
            console.log('supplier => ' + JSON.stringify(supplier));
            SupplierService.updateSupplier(supplier, this.state.sid).then( res =>{
                this.notify();
                this.props.history.push('/view-supplier');
            });

        }
        
    }
 
    changeSupplierIdHandler = (event) => {
        this.setState({sid: event.target.value});
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
    changePasswordHandler = (event) => {
        this.setState({password: event.target.value});
    }
    
    cancel(){
        this.props.history.push('/employees')
    }
    render() {
        return (
            <div>
                <div className="container">
                    <div className="row" className="css">
                        <div className = "card col-md-6 offset-md-3 offset-md-3">
                            <h3 className = "text-center"><b>Update Supplier</b></h3>
                            <div className = "card-body">
                                <form>
                                    <div className = "form-group"> 
                                        <label>Supplier Id:</label>
                                        <input placeholder = "Supplier Id" name="sid" className = "form-control"
                                            value={this.state.sid} onChange={this.changeSupplierIdHandler} readOnly/>
                                        
                                     </div> 
                                    <div className = "form-group">
                                        <label>Name:</label>
                                        <input placeholder = "Name" name="name" className = "form-control"
                                            value={this.state.name} onChange={this.changeNameHandler}/>
                                        <div style ={{fontSize:"14px", color:"red"}}>{this.state.nameError}</div>
                                    </div>
                                    <div className = "form-group">
                                        <label>Email Id:</label>
                                        <input type = "email" placeholder = "EmailId" name="emailId" className = "form-control"
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
                                            value={this.state.phone} onChange={this.changePhoneHandler}/>
                                        <div style ={{fontSize:"14px", color:"red"}}>{this.state.phoneError}</div>
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
                                        <div style ={{fontSize:"14px", color:"red"}}>{this.state.categoryError}</div>


                                    </div>
                                    
                                   
                                    
                                    <button type="submit" style = {{width:150}} className = "forminputbtn1"/*className = "btn btn-success"*/   onClick = {this.updateSupplier}>UPDATE</button>
                                    <button type="reset" className = "forminputbtn2" /*className = "btn btn-danger"*/ onClick = {this.cancel.bind(this)} style={{marginLeft: "10px"}}>RESET</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

export default UpdateSupplier;

