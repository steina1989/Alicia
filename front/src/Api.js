import path from 'path';
const baseurl = process.env.REACT_APP_SERVICE_URL;

async function get(endpoint) {
  const url = path.join(baseurl, endpoint);

  const response = await fetch(url);
  const result = await response.json();
  return { result, status: response.status };
}

async function post(data, endpoint, method = 'POST') {
  const url = path.join(baseurl, endpoint);

  const options = {
    method: method,
    body: JSON.stringify(data),
    headers: {}
  };

  // Handle image upload.
  if (endpoint !== 'users/me/profile') {
    options.headers['Content-Type'] = 'application/json';
  }

  const response = await fetch(url, options);
  const result = await response.json();
  return { result, status: response.status };
}

async function addAssignment(assignmentId, file) {
  const url = `/api/addAnswer/${assignmentId}`;
  const formData = new FormData();
  formData.append('uploadedFile', file);
  const config = {
    method: 'POST',
    body: formData
  };
  try {
    const result = await fetch(url, config);
    console.log(result);
  } catch (error) {
    console.log(error);
  }
}

export default {
  get,
  post,
  addAssignment
};
