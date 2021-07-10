import axios from 'axios';

const PURCHASEDITEMDETAIL_API_BASE_URL = "http://localhost:8080/api/v1/purchased_item_detail";

class PurchasedItemDetailService{

    getPurchasedItemDetail(){
        return axios.get(PURCHASEDITEMDETAIL_API_BASE_URL);
    }
    getPurchasedItemDetailById(invoiceNo){
        return axios.get(PURCHASEDITEMDETAIL_API_BASE_URL + '/' + invoiceNo);
    }
    updatePurchasedItemDetail(purchaseditemdetail, invoiceNo){
        return axios.put(PURCHASEDITEMDETAIL_API_BASE_URL  + '/' + invoiceNo, purchaseditemdetail);
    }
    deletePurchasedItemDetail(invoiceNo){
        return axios.delete(PURCHASEDITEMDETAIL_API_BASE_URL + '/' + invoiceNo);
    }
    addPurchasedItem(purchaseditemdetail){
        return axios.post(PURCHASEDITEMDETAIL_API_BASE_URL, purchaseditemdetail);
    }

}
 export default new PurchasedItemDetailService()
