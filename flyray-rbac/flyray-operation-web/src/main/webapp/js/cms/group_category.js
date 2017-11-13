$(function () {
    $("#jqGrid").jqGrid({
        url: '../cms/groupcategory/list',
        datatype: "json",
        colModel: [			
			{ label: 'ID', name: 'id', index: "id", width: 45, key: true },
			{ label: '团队类别', name: 'categoryName', index:"category_name", width: 45},
            { label: '组织', name: 'orgId', index:"org_id", width: 45},
            { label: '商户', name: 'merchantId', index:"merchant_id", width: 45},
            { label: '创建时间', name: 'createtime', index:"createtime", width: 45},
            { label: '标记', name: 'flag', index:"flag", width: 45}
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
            categoryName: null
		},
		showList: true,
		title:null,
        groupcategory:{
			id:null,
			categoryName:null,
			orgId:null,
			merchantId:null,
			createtime:null,
			flag:null,
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
			
			vm.getGroupcategory(id);
		},
		del: function () {
			var ids = getSelectedRows();
			if(ids == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: "../cms/groupcategory/delete",
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
			var url = vm.groupcategory.id == null ? "../cms/groupcategory/save" : "../cms/groupcategory/update";
			$.ajax({
				type: "POST",
			    url: url,
			    data: JSON.stringify(vm.groupcategory),
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
        getGroupcategory: function(id){
			$.get("../cms/groupcategory/info/"+id, function(r){
				vm.groupcategory = r.groupcategory;
			});
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                postData:{'categoryName': vm.q.categoryName},
                page:page
            }).trigger("reloadGrid");
		}
	}
});