
import axios from 'axios'
import { ElMessage } from 'element-plus'
axios.defaults.baseURL = 'http://127.0.0.1'
axios.defaults.withCredentials = false

// function require
// 请求拦截器
axios.interceptors.request.use(
  (config) => {
    // console.log(config);
    return config
  },
  (error) => {
    console.log(error)
    return Promise.reject(error)
  }
)

// 响应拦截器
axios.interceptors.response.use(
  (response) => {
    if (
      response.status === 200 ||
      response.status === 202 ||
      response.status === 201
    ) {
      return Promise.resolve(response)
    }
    else console.log('error');
  },
  // 服务器状态码不是200的情况
  (error) => {
    if (error.response.status) {
      // console.log(error)
      // console.log(error.response)
      switch (error.response.status) {
        case 404:
          Message.warning('接口不存在，请刷新重试或联系管理员')
          break
        case 500:
          Message.error('服务异常，请稍后刷新重试或联系管理员')
          break
        case 502:
          Message.error('服务异常，请稍后刷新重试或联系管理员')
          break
        default:
          Message.warning(error.response.data.message)
          return Promise.reject(error.response)
      }
    }
  }
)
let defaultConfig = {
  url: '',
  header: {
    'Content-Type': 'application/json;charset=UTF-8',
    "Access-Control-Allow-Origin": "*"
  },
  data: {},
}
function request(options) {
  axios.defaults.withCredentials = false
  if (!options) options = {}
  options.baseUrl = options.baseUrl || defaultConfig.baseUrl
  options.dataType = options.dataType || defaultConfig.dataType
  options.url = options.url
  options.method = options.method || defaultConfig.method
  // console.log(options)
  // console.log(options.method)
  return new Promise((resolve, reject) => {
    axios(options)
      .then((res) => {
        // console.log(res)
        resolve(res.data)
      })
      .catch((err) => {
        ElMessage.error('请求出错！')
      })
  })
}
/**
 * 封装 get方法 对应 GET 请求
 * @param {string} url 请求url
 * @param {object} params 查询参数
 * @returns {Promise}
 */
export function get(url, params, options) {
  if (!options) {
    options = {}
  }
  options.url = url
  options.params = params
  options.method = 'GET'
  return request(options)
}
/**
 * 封装 post 方法，对应 POST 请求
 * @param {string} url 请求url
 * @param {object} data 请求体
 * @param {boolean | undefined} paramsMode 请求体是否为路劲参数格式
 * @returns {Promise}
 */
export function post(url, data = {}, options, paramsMode = false) {
  if (!options) {
    options = {}
  }
  options.url = url
  options.method = 'POST'
  if (paramsMode) {
    options.params = data
    return request(options)
  } else {
    options.data = data
    return request(options)
  }
}
/**
 * 封装 put 方法，对应 PUT 请求
 * @param {string} url 请求url
 * @param {object} params 请求体
 * @returns {Promise}
 */
export function put(url, params = {}, options, paramsMode = false) {
  if (!options) {
    options = {}
  }
  options.url = url
  options.method = 'PUT'

  if (paramsMode) options.params = params
  else options.data = params
  return request(options)
}

/**
 * 封装 axiosDelete 方法，对应 DELETE 请求
 * @param {string} url 请求url
 * @param {object} params 请求体
 * @returns {Promise}
 */
export function axiosDelete(url, params = {},options) {
  if (!options) {
    options = {}
  }
  options.url = url
  options.method = 'DELETE'

  options.params = params
  return request(options)
}
