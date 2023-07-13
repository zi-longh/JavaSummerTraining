const filterGoodsType = (type) => {
  switch (type) {
    case '0':
      return '日用品'
    case '1':
      return '零食'
    case '2':
      return '服装'
    case '3':
      return '玩具'
    case '4':
      return '鞋包'
    default:
      return '其他'
  }
}

const filterOffice = (office) => {
  switch (office) {
    case '0':
      return '经理'

    case '1':
      return '销售员'

    case '2':
      return '收银员'

    case '3':
      return '理货员'

    case '4':
      return '安保'
    default:
      return '员工'
  }
}
export default{
  filterGoodsType,
  filterOffice
}