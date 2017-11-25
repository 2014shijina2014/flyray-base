$(function () {
    $("#jqGrid").jqGrid({
        url: '../pay/payOrder/list',
        datatype: "json",
        colModel: [			
			{ label: 'ID', name: 'id', index: "id", width: 45, key: true },
			{ label: '订单号', name: 'payOrderNo', width: 75 },
			{ label: '客户账号', name: 'customerNo', width: 75 },
			{ label: '商户账号', name: 'merchantNo', width: 75 },
			{ label: '交易时间', name: 'payTime', width: 75 },
			{ label: '交易手续费', name: 'payFee', width: 75 },
			{ label: '交易金额', name: 'payAmt', width: 75 },
			{ label: '订单描述', name: 'body', width: 75 },
			{ label: '商户订单号', name: 'outTradeNo', width: 75 },
			{ label: '支付方式', name: 'payMethod', width: 90 },
			{ label: '交易状态', name: 'orderStatus', width: 100 },
			{ label: '机构编号', name: 'orgNo', width: 100 },
			{ label: '已退款金额', name: 'redundedAmt', width: 100 }
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page", 
            rows:"limit", 
            order: "order"
        },
        gridComplete:function(){
        	//隐藏grid底部滚动条
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });
});

var vm = new Vue({
	el:'#rrapp',
	data:{
		q:{
			payChannelNo: null
		},
		showList: true,
		title:null,
		payOrder:{
			payChannelNo:null,
			payCompanyNo:null,
			feeRatio:null,
		}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
		},
		update: function () {
			var id = getSelectedRow();
			if(id == null){
				return ;
			}
			
			vm.showList = false;
            vm.title = "修改";
			
			vm.getPayOrder(id);
		},
		del: function () {
			var ids = getSelectedRows();
			if(ids == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: "../pay/payOrder/delete",
				    data: JSON.stringify(ids),
				    success: function(r){
						if(r.code == 0){
							alert('操作成功', function(index){
                                vm.reload();
							});
						}else{
							alert(r.msg);
						}
					}
				});
			});
		},
		saveOrUpdate: function (event) {
			var url = vm.payOrder.id == null ? "../pay/payOrder/save" : "../pay/payOrder/update";
			$.ajax({
				type: "POST",
			    url: url,
			    data: JSON.stringify(vm.payOrder),
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功', function(index){
							vm.reload();
						});
					}else{
						alert(r.msg);
					}
				}
			});
		},
		getPayOrder: function(id){
			$.get("../pay/payOrder/info/"+id, function(r){
				vm.payOrder = r.payOrder;
			});
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                postData:{'orgName': vm.q.orgName},
                page:page
            }).trigger("reloadGrid");
		}
	}
});