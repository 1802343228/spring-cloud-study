// pages/personal/personal.js
const app = getApp();
const API = require('../../utils/request.js')

Page({

  /**
   * 页面的初始数据
   */
  data: {
    userInfo: null,
    isUserSignIn: 0
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    // console.log(this.data.userInfo.isUserSignIn)
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
    this.setData({
      userInfo: app.globalData.user
    })
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  },

  /**
   * 登录，目前只是走个形式
   */
  weixinLogin() {
    API.login({
      openId: app.globalData.wxId,
      wxNickname: app.globalData.userInfo.nickName,
      avatarUrl: app.globalData.userInfo.avatarUrl
    }).then(res => {
      const request = JSON.parse(res)
      console.log(request)
      app.globalData.user = request.user
      app.globalData.token = request.token.token
      console.log(app.globalData.token)
      this.setData({
        userInfo: app.globalData.user,
      })
      API.checkSignIn({
        userId:this.data.userInfo.id
      }).then(res => {
        console.log(res)
        if(res.code == 201){
          this.setData({
            isUserSignIn:1
          })
        }
       
      })
      console.log(this.data.isUserSignIn)
    })
  },
  goevent:function() {
    wx.navigateTo({
      url: '/pages/jifenmingxi/jifenmingxi',
    })
  },
  goexchange:function() {
    wx.navigateTo({
      url: '/pages/wodeduihuan/wodeduihuan',
    })
  },
  gocontribute:function() {
    wx.navigateTo({
      url: '/pages/wodetougao/wodetougao',
    })
  },
  qiandao:function() {
    console.log(this.data.userInfo.id)
    API.signIn({
      userId:this.data.userInfo.id
    }).then(res => {
      console.log(res)
      API.checkSignIn({
        userId:this.data.userInfo.id
      }).then(res => {
        console.log(res)
        if(res.code == 201){
          this.setData({
            isUserSignIn:1
          })
          wx.showToast({
            title: '签到成功',
            icon: 'success',
            duration: 2000
        })
        }
       
      })

  })
  }
})