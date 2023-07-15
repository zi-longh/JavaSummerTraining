import { get, post,put,axiosDelete } from './http'
const prefix = "/sale"
const getSalesInfo = async (data) => await get(`${prefix}/getSalesInfo`, data)
const getAllSalesInfo = async (data) => await get(`data/getInfo3`, data)
const updateSaleById = async (data) => await put(`${prefix}/updateSale`, data)
const deleteSaleById = async (id) => await axiosDelete(`${prefix}/deleteSaleById/${id}`)
const addSale = async (data) => await post(`${prefix}/addSale`, data)
const addSales = async (data) => await post(`data/sellGoods`, data)
export default {
  getSalesInfo,
  updateSaleById,
  deleteSaleById,
  addSale,
  getAllSalesInfo,
  addSales
}
