$(function () {
    $("#jqGrid").jqGrid({
        url: '../pay/paySerial/list',
        datatype: "json",
        colModel: [			
			{ label: '支付流水号', name: 'serialNo', index: "serialNo", width: 45, key: true },
			{ label: '订单号', name: 'payOrderNo', width: 75 },
			{ label: '支付渠道号', name: 'payChannelNo', width: 90 },
			{ label: '支付公司编号', name: 'payCompanyNo', width: 90 },
			{ label: '交易金额', name: 'payAmt', width: 90 },
			{ label: '交易手续费', name: 'payFee', width: 90 },
			{ label: '支付记账状态', name: 'accountStatus', width: 90 },
			{ label: '支付状态', name: 'payStatus', width: 100 }
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
		paySerial:{
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
			
			vm.getPaySerial(id);
		},
		del: function () {
			var ids = getSelectedRows();
			if(ids == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: "../pay/paySerial/delete",
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
			var url = vm.paySerial.id == null ? "../pay/paySerial/save" : "../pay/paySerial/update";
			$.ajax({
				type: "POST",
			    url: url,
			    data: JSON.stringify(vm.paySerial),
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
		getPaySerial: function(id){
			$.get("../pay/paySerial/info/"+id, function(r){
				vm.paySerial = r.paySerial;
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