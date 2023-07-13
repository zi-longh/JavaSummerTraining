module.exports = {
    devServer: {
      historyApiFallback: true,
      allowedHosts: "all",
       host: 'localhost',//对应的主机名
       port: 8080,//端口号
       https: false,//是否开启协议名,如果开启会发出警告
      // proxy: {
      //   // 和上面自定义的 baseURL 保持一致
      //   '/api': {
      //     target: 'http://127.0.0.1:80/',
      //     changeOrigin:true,
      //     ws: true,
      //     pathRewrite: { '^/api': '' },
      //   }
      // }
    },
}
