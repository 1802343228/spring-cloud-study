//const { EAGAIN } = require("constants");

//统一接口封装
const API_BASE_URL = 'http://localhost:8040';
const app = getApp()

const get = (url, data) => {
  let _url = API_BASE_URL + url;
  return new Promise((resolve, reject) => {
    wx.showLoading({
      title: "正在加载中...",
    })
    wx.request({
      url: _url,
      method: "get",
      data: data,
      header: {
        'Content-Type': 'application/x-www-form-urlencoded',
        'X-Token': app.globalData.token
      },
      success(request) {
        wx.hideLoading();
        resolve(request.data)
      },
      fail(error) {
        reject(error)
      }
    })
  });
}
const post = (url, data, contentType) => {
  let _url = API_BASE_URL + url;
  switch (contentType) {
    case "form":
      var headerObj = {
        'content-type': 'application/x-www-form-urlencoded'
      };
      break;
    case "json":
      var headerObj = {
        'content-type': 'application/json'
      };
      break;
    default:
      var headerObj = {
        'content-type': 'application/json'
      };
  }
  return new Promise((resolve, reject) => {
    wx.request({
      url: _url,
      data: data,
      method: "POST",
      dataType: JSON,
      header: headerObj,
      success(request) {
        resolve(request.data)
      },
      fail(error) {
        reject(error)
      }
    })
  });
}
const put = (url, data, contentType) => {
  let _url = API_BASE_URL + url;
  switch (contentType) {
    case "form":
      var headerObj = {
        'content-type': 'application/x-www-form-urlencoded'
      };
      break;
    case "json":
      var headerObj = {
        'content-type': 'application/json'
      };
      break;
    default:
      var headerObj = {
        'content-type': 'application/json'
      };
  }
  return new Promise((resolve, reject) => {
    wx.request({
      url: _url,
      data: data,
      method: "PUT",
      dataType: JSON,
      header: headerObj,
      success(request) {
        resolve(request.data)
      },
      fail(error) {
        reject(error)
      }
    })
  });
}
module.exports = {
  login: (data) => {
    console.log("登录")
    return post('/users/login', data, 'json') //微信登录
  },
  getShares: (data) => {
    console.log('获取分享列表')
    return get('/shares/query', data) //获取分享列表
  },
  getNotic: () => {
    console.log('获取最新公告')
    return get('/notice/one') //获取最新公告
  },
  contribute: (data) => {
    console.log('投稿')
    return post('/shares/contribute', data, 'json') //投稿
  },
  exchange: (data) => {
    console.log('兑换')
    return post('/shares/exchange', data, 'json') //兑换
  },
  findById: () => {
    console.log('查询用户积分')
    return get('/users/' + app.globalData.user.id, 'json') //查询用户积分
  },
  signIn: (data) => {
    console.log('签到加积分')
    return get('/users/signIn',data,'json')//签到
  },
  checkSignIn: (data) => {
    console.log('检查今天是否已签到')
    return get('/users/check/signIn',data,'json')//检查签到
  },
  getBonusEvent:(data) =>{
    console.log("获取积分明细")
    return get('/bonus/find',data,'json')//获取积分明细
  },
  getExchange:(data) =>{
    console.log("获取我的兑换")
    return get('/shares/find/exchange',data,'json')//获取我的兑换
  },
  getContribute:(data) =>{
    console.log("获取我的投稿")
    return get('/shares/find/contribute',data,'json')//获取我的投稿
  },
}