import React, { Component } from 'react';
import PurchasedItemDetailService from '../adapters/PurchasedItemDetailServiceIT19989242';

class ViewPurchasedItemDetailComponent extends Component {

    constructor(props){
        super(props);

        this.state = {
            id:this.props.match.params.id,
            purchaseditemdetail: {}
        }
    }
    componentDidMount(){
        PurchasedItemDetailService.getPurchasedItemDetailById(this.state.id).then(res =>{
            this.setState({purchaseditemdetail: res.data});
        })
    }
    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3" style ={{marginTop: "10px"}}>
                    <h2 className = "tableheading" style = {{marginLeft:"10px", width: "500px"}}><b>  Purchased Item Details</b></h2>
                    <div className = "card-body">
                        <div className = "row">
                            <label><b>Invoice No:</b></label><br></br><br></br>
                            <div>{this.state.purchaseditemdetail.invoiceNo}</div>
                        </div>
                        
                        <div className = "row">
                            <label><b>Item Code:</b></label>
                            <div>{this.state.purchaseditemdetail.itemCode}</div>
                        </div>
                        <div className = "row">
                            <label><b>Item Name:</b></label>
                            <div>{this.state.purchaseditemdetail.itemName}</div>
                        </div>
                        <div className = "row">
                            <label><b>Item Category:</b></label>
                            <div>{this.state.purchaseditemdetail.it_Category}</div>
                        </div>
                        <div className = "row">
                            <label><b>Description:</b></label>
                            <div>{this.state.purchaseditemdetail.description}</div>
                        </div>
                        <div className = "row">
                            <label><b>Supplier Id:</b></label>
                            <div>{this.state.purchaseditemdetail.sid}</div>
                        </div>
                        <div className = "row">
                            <label><b>Date:</b></label>
                            <div>{this.state.purchaseditemdetail.date}</div>
                        </div>
                        <div className = "row">
                            <label><b>Payment:</b></label>
                            <div>{this.state.purchaseditemdetail.payment}</div>
                        </div>
                        
                    </div>
                </div>
                
            </div>
        );
    }
}

export default ViewPurchasedItemDetailComponent;