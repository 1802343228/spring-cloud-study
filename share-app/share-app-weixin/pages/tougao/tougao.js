// pages/tougao/tougao.js
const app = getApp();
const API = require('../../utils/request.js')

Page({

  /**
   * 页面的初始数据
   */
  data: {
    isOriginal:0,
    title:null,
    author:null,
    price:null,
    downloadUrl:null,
    simple:null
  },
  bindTitle:function(e) {
    this.setData({
      title: e.detail.value
    })
  },
  bindAuthor:function(e) {
    this.setData({
      author: e.detail.value
    })
  },
  bindPrice:function(e) {
    this.setData({
      price: e.detail.value
    })
  },
  bindSimple:function(e) {
    this.setData({
      simple: e.detail.value
    })
  },
  bindDown:function(e) {
    this.setData({
      downloadUrl: e.detail.value
    })
  },
   /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

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
  /**
   * 
   */
  radioChange(e) {
    console.log('radio发生change事件，携带value值为：', e.detail.value)
  },
  //投稿按钮
  contribute() {
    var isOriginal = false
    if(this.data.isOriginal == 0) {
        isOriginal=true
    }
    API.contribute({
      userId: 7,
      title: this.data.title,
      isOriginal: isOriginal,
      author: this.data.author,
      cover: "https://i2.wp.com/e4developer.com/wp-content/uploads/2018/01/spring-cloud-logo.png?resize=800%2C753&ssl=1",
      summary: this.data.simple,
      price: this.data.price,
      downloadUrl: this.data.downloadUrl
    }).then( res =>{
      const request = JSON.parse(res)
      console.log(request)
      wx.showToast({
        title: '投稿成功',
        icon: 'success',
        duration: 2000
    })
      this.setData({
        userInfo:app.globalData.user
      })
    })
  }
})