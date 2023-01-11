import React, {useEffect, useState} from 'react'
import "./Lists.css"

const List = () => {

  const [district, setDistrict] = useState([]);
  useEffect(() => {
    fetch("http://localhost:8999/district/count").then((result) => {
      result.json().then((resp) => {
        //console.log(resp);
        setDistrict(resp)
        console.log(resp);
      })
    })
  }, [])
  console.log(district);

  const [genre, setGenre] = useState([]);
  useEffect(() => {
    fetch("http://localhost:8999/genre/count").then((result) => {
      result.json().then((resp) => {
        //console.log(resp);
        setGenre(resp)
        console.log(resp);
      })
    })
  }, [])
  console.log(genre);
  return (
      <div>
        <h1>Tree</h1>

        <div className="main"><br/>

          <table className="table1">
            <h2> District</h2>

            <tbody>
            <tr>
              <td>District</td>
              <td>nbTrees</td>
            </tr>
            {
              district.map((dis, i) =>
                  <tr key={i}>
                    <td>{dis.value}</td>
                    <td>{dis.nbTrees}</td>
                  </tr>
              )
            }
            </tbody>
          </table>

          <table className="table2">
            <h2> Genre</h2>
            <tbody>
            <tr>
              <td>Genre</td>
              <td>nbTrees</td>
            </tr>
            {
              genre.map((gen, i) =>
                  <tr key={i}>
                    <td>{gen.value}</td>
                    <td>{gen.nbTrees}</td>
                  </tr>
              )
            }
            </tbody>
          </table>


        </div>
      </div>
  );
}
export default List