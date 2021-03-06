//app.js
App({
  onLaunch: function () {
    // 展示本地存储能力
    // var logs = wx.getStorageSync('logs') || []
    // logs.unshift(Date.now())
    // wx.setStorageSync('logs', logs)

    // 登录
    wx.login({
      success: res => {
        wx.request({
          url: 'https://api.weixin.qq.com/sns/jscode2session',
          data:{
            appid: 'wxedc274aca2fb67b1',
            secret: '4d8b9f7eb8997e2424ed80f4cff3e1dc',
            js_code: res.code,
            grant_type: 'authorization_code'
          },
          success: res =>{
            console.log(res)
            this.globalData.wxId = res.data.openid
          }
        })
        // 发送 res.code 到后台换取 openId, sessionKey, unionId
      }
      
    })
    // 获取用户信息
    wx.getSetting({
      success: res => {
        if (res.authSetting['scope.userInfo']) {
          // 已经授权，可以直接调用 getUserInfo 获取头像昵称，不会弹框
          wx.getUserInfo({
            success: res => {
              console.log(res)
              // 可以将 res 发送给后台解码出 unionId
              this.globalData.userInfo = res.userInfo
              console.log(this.globalData.userInfo)
              // 由于 getUserInfo 是网络请求，可能会在 Page.onLoad 之后才返回
              // 所以此处加入 callback 以防止这种情况
              if (this.userInfoReadyCallback) {
                this.userInfoReadyCallback(res)
              }
            }
          })
        } 
      }
    })
  },
  globalData: {
    userInfo: null,
    user: null,
    token:null,
    shareList:null,
    openId: ''
  }
})