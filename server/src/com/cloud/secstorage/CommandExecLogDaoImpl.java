// Copyright 2012 Citrix Systems, Inc. Licensed under the
// Apache License, Version 2.0 (the "License"); you may not use this
// file except in compliance with the License.  Citrix Systems, Inc.
// reserves all rights not expressly granted by the License.
// You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
// 
// Automatically generated by addcopyright.py at 04/03/2012
package com.cloud.secstorage;

import java.util.Date;

import javax.ejb.Local;

import com.cloud.utils.db.GenericDaoBase;
import com.cloud.utils.db.SearchBuilder;
import com.cloud.utils.db.SearchCriteria;
import com.cloud.utils.db.SearchCriteria.Op;

@Local(value={CommandExecLogDao.class})
public class CommandExecLogDaoImpl extends GenericDaoBase<CommandExecLogVO, Long> implements CommandExecLogDao {

    protected final SearchBuilder<CommandExecLogVO> ExpungeSearch;
	
	public CommandExecLogDaoImpl() {
		ExpungeSearch = createSearchBuilder();
		ExpungeSearch.and("created", ExpungeSearch.entity().getCreated(), Op.LT);
		ExpungeSearch.done();
	}
	
	@Override
	public void expungeExpiredRecords(Date cutTime) {
		SearchCriteria<CommandExecLogVO> sc = ExpungeSearch.create();
		sc.setParameters("created", cutTime);
		expunge(sc);
	}
}

