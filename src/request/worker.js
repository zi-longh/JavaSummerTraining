// import http from './http'
import { get, post,put,axiosDelete } from './http'
const login = async (data) => await post('/login', data)
const prefix = "/worker"
const getUserInfoById = async (data) => await get(`${prefix}/getUserInfoById`, data)
// 添加员工
const addWorker = async (data) => await post(`${prefix}/addWorker`, data)
// 查询员工信息
const getWorkersInfo = async (data) => await get(`${prefix}/getWorkersInfo`, data)
// 查询所有员工信息
const getAllWorkersInfo = async () => await get(`${prefix}/getAllWorkersInfo`)
// 更新员工信息
const updateWorkerById = async (data) => await put(`${prefix}/updateWorker`, data)
// 删除员工信息
const deleteWorkerById = async (workerNum) => await axiosDelete(`${prefix}/deleteWorkerById/${workerNum}`)
// 获取员工编号
const getWorkersNum = async () => await get( `${prefix}/getWorkersNum`)
export default {
  login,
  getUserInfoById,
  addWorker,
  getWorkersInfo,
  updateWorkerById,
  deleteWorkerById,
  getAllWorkersInfo,
  getWorkersNum,
}
