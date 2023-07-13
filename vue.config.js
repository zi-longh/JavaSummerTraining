module.exports = {
    devServer: {
      proxy: {
        // 和上面自定义的 baseURL 保持一致
        '/api': {
          target: 'http://127.0.0.1:80/',
          changeOrigin:true,
          ws: true,
          pathRewrite: { '^/api': '' },
        }
      }
    },
}
