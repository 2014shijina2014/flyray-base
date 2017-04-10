$(function () {
    $("#jqGrid").jqGrid({
        url: '../pay/payChannel/list',
        datatype: "json",
        colModel: [			
			{ label: 'ID', name: 'id', index: "id", width: 45, key: true },
			{ label: '支付通道', name: 'payChannelNo', width: 75 },
			{ label: '支付公司', name: 'payCompanyNo', width: 90 },
			{ label: '费率', name: 'feeRatio', width: 100 },
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
			orgName: null
		},
		showList: true,
		title:null,
		org:{
			orgName:null,
			parentId:0,
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
			var orgId = getSelectedRow();
			if(orgId == null){
				return ;
			}
			
			vm.showList = false;
            vm.title = "修改";
			
			vm.getOrg(orgId);
		},
		del: function () {
			var orgIds = getSelectedRows();
			if(orgIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: "../sys/org/delete",
				    data: JSON.stringify(orgIds),
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
			var url = vm.org.orgId == null ? "../sys/org/save" : "../sys/org/update";
			$.ajax({
				type: "POST",
			    url: url,
			    data: JSON.stringify(vm.org),
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
		getOrg: function(orgId){
			$.get("../sys/org/info/"+orgId, function(r){
				vm.org = r.org;
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