// pages/wodeduihuan/wodeduihuan.js
const app = getApp()
const API = require('../../utils/request.js')
Page({

  /**
   * 页面的初始数据
   */
  data: {
    shareList:null
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this
    API.getExchange({
      userId:app.globalData.user.id
    }).then(res => {
      console.log(res)
      that.setData({
        shareList:res
      })
    })
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
  downloadUrl:function(e) {
    //取出绑定对象
    var share1 = e.currentTarget.dataset.item
    var share=JSON.stringify(share1)
    console.log(share)
    wx.navigateTo({
      url: '../duihuanSuccess/duihuanSuccess?share=' + encodeURIComponent(share),
    })
  }
})