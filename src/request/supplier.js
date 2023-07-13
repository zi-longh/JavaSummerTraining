import { get, post,put,axiosDelete } from './http'
const prefix = "/supplier"
const getSupplierInfo = async (data) => await get(`${prefix}/getSupplierInfo`, data)
const getAllSuppliersInfo = async (data) =>
  await get(`${prefix}/getAllSuppliersInfo`, data)
const updateSupplierById = async (id) => await put(`${prefix}/updateSupplier`, id)
const deleteSupplierById = async (id) => await axiosDelete(`${prefix}/deleteSupplierById/${id}`)
const addSupplier = async (data) => await post(`${prefix}/addSupplier`, data)
const getSuppliersNum = async () => await get(`${prefix}/getSuppliersNum`)
export default {
  getSupplierInfo,
  updateSupplierById,
  deleteSupplierById,
  addSupplier,
  getAllSuppliersInfo,
  getSuppliersNum,
}
