$(function () {
    $("#jqGrid").jqGrid({
        url: '../cms/topic/list',
        datatype: "json",
        colModel: [			
			{ label: 'ID', name: 'id', index: "id", width: 45, key: true },
			{ label: '标题', name: 'title', width: 45}
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
		payChannel:{
			payChannelNo:null,
			payCompanyNo:null,
			feeRatio:null,
		},
		topic:{
			id:null,
			content:null,
			title:null,
			discription:null,
			img:null
		},
		images:[],
		imgFile: ''
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
			
			vm.getPayChannel(id);
		},
		del: function () {
			var ids = getSelectedRows();
			if(ids == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: "../pay/payChannel/delete",
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
			var url = vm.topic.id == null ? "../cms/topic/save" : "../pay/payChannel/update";
			alert(url);
			$.ajax({
				type: "POST",
			    url: url,
			    data: JSON.stringify(vm.topic),
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
		getPayChannel: function(id){
			$.get("../pay/payChannel/info/"+id, function(r){
				vm.payChannel = r.payChannel;
			});
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                postData:{'title': vm.q.title},
                page:page
            }).trigger("reloadGrid");
		},
		addPic: function (e) {
            e.preventDefault();
            $('input[type=file]').trigger('click');
            return false;
        },
        onFileChange: function (e) {
            var files = e.target.files || e.dataTransfer.files;
            if (!files.length)return;
            if	(files.length > 1) {
            	alert("只能上传一张图片");
            	return;
            }
            console.log(files);
            this.images = [];
            var file = files[0];
            console.log(file);
            
            this.createImage(files);
        },
        createImage: function(file) {
            if(typeof FileReader==='undefined'){
                alert('您的浏览器不支持图片上传，请升级您的浏览器');
                return false;
            }
            var image = new Image();         
            var vm = this;
            var leng=file.length;
            for(var i=0;i<leng;i++){
                var reader = new FileReader();
                reader.readAsDataURL(file[i]); 
                reader.onload =function(e){
                  vm.topic.img = e.target.result;
                  vm.images.push(e.target.result);                                    
                };                 
            }                        
        },
        delImage:function(index){
            this.images.shift(index);
        },
        removeImage: function(e) {
            this.images = [];
        },
        uploadImage: function() {
            console.log(this.images);
            return false;
            var obj = {};
            obj.images=this.images
            $.ajax({
                type: 'post',
                url: "../cms/topic/save",
                data: obj,
                dataType: "json",
                success: function(data) {
                    if(data.status){
                        alert(data.msg);
                        return false;
                    }else{
                        alert(data.msg);
                        return false;
                    }
                }
            });
        }
	}
});