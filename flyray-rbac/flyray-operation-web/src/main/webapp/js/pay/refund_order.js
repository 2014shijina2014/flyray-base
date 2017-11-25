$(function () {
    $("#jqGrid").jqGrid({
        url: '../pay/refundOrder/list',
        datatype: "json",
        colModel: [			
			{ label: 'ID', name: 'id', index: "id", width: 45, key: true },
			{ label: '支付订单号', name: 'payOrderNo', width: 75 },
			{ label: '退款订单号', name: 'refundOrderNo', width: 90 },
			{ label: '退款金额', name: 'refundAmt', width: 100 },
			{ label: '机构编号', name: 'orgNo', width: 100 },
			{ label: '退款手续费', name: 'refundFee', width: 100 },
			{ label: '跟支付方式对应', name: 'refundMethod', width: 100 },
			{ label: '退款原因', name: 'refundReason', width: 100 },
			{ label: '商户订单号 商户传', name: 'outTradeNo', width: 100 }
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
		refundOrder:{
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
			
			vm.getRefundOrder(id);
		},
		del: function () {
			var ids = getSelectedRows();
			if(ids == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: "../pay/refundOrder/delete",
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
			var url = vm.refundOrder.id == null ? "../pay/refundOrder/save" : "../pay/refundOrder/update";
			$.ajax({
				type: "POST",
			    url: url,
			    data: JSON.stringify(vm.refundOrder),
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
		getRefundOrder: function(id){
			$.get("../pay/refundOrder/info/"+id, function(r){
				vm.refundOrder = r.refundOrder;
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