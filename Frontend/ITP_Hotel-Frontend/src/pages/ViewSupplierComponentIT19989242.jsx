import React, { Component } from 'react';
import SupplierService from '../adapters/SupplierServiceIT19989242';

class ViewSupplierComponent extends Component {
    constructor(props){
        super(props);

        this.state = {
            id: this.props.match.params.id,
            supplier: {}
        }
    }
    componentDidMount(){
        SupplierService.getSupplierById(this.state.id).then( res => {
            this.setState({supplier: res.data});
        })
    }
    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3" style ={{marginTop: "10px"}}>
                    <h2  style={{marginLeft: "40px", width:"450px"}} className = "tableheading"><b> Supplier Details</b></h2>
                    <div className = "card-body">
                        <div className = "row">
                            <label><b>Supplier Id:</b></label>
                            <div>{this.state.supplier.sid}</div>
                        </div>
                        
                        <div className = "row">
                            <label><b>Supplier Name:</b></label>
                            <div>{this.state.supplier.name}</div>
                        </div>
                        <div className = "row">
                            <label><b>Category:</b></label>
                            <div>{this.state.supplier.category}</div>
                        </div>
                        <div className = "row">
                            <label><b>Email:</b></label>
                            <div>{this.state.supplier.email}</div>
                        </div>
                        <div className = "row">
                            <label><b>NIC:</b></label>
                            <div>{this.state.supplier.nic}</div>
                        </div>
                        <div className = "row">
                            <label><b>Phone Number:</b></label>
                            <div>{this.state.supplier.phone}</div>
                        </div>
                        
                    </div>
                </div>
            </div>
        );
    }
}

export default ViewSupplierComponent;